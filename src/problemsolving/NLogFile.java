package problemsolving;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.testng.annotations.Test;

/* PROBLEM STATEMENT: there are N log files with format "timestamp task_id content". Write a program to 
 * read thru all these files and print log file content in chronological order for a specific task_id also
 * append file name to output log content
 * 
 * WHAT NEW I TRIED: in addition to our discussion. where this algorithm was developed in sequential with time complexity of O(mn), I developed this in O(m log n) using merge sort
 * where n is number of log files and m is average number of lines in log files.
 * 
 * this algorithm can still be improved to remove filepointer  from file pointer and list when specific pointer reach end of line they reach the end of line
 * 
 * Thanks
 * Sohan
 * */

public class NLogFile {
	ArrayList<BufferedReader> filePointerList; 
	
	@Test 
	public void test1() throws FileNotFoundException {
		String[] files = {"a.log","b.log","c.log"};
		System.out.println("for t_id1");
		getAnalysisofTaskId(files, "t_id1");
	}
	
	@Test 
	public void test2() throws FileNotFoundException {
		String[] files = {"a.log","b.log","c.log"};
		System.out.println("\nfor t_id7");
		getAnalysisofTaskId(files, "t_id7");
	}
	

	private void getAnalysisofTaskId(String [] files, String taskId) {
		
		filePointerList = new ArrayList<BufferedReader>();
		try {
			openFilesAndPutinFilePointerlist(files);
			while (!allFilePointerEndofLine()){
				int i = getEarliest(0,filePointerList.size()-1,taskId);
				printFileContent(i,files);
			}
			closeFiles();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}



	private int getEarliest(int i, int j,String taskId) {
		if(j-i==0) {  
			moveFilePointertoNextMatchedTaskId(i,taskId);
			rewindFilePontersOneLine(i);
			return i;
		}
		else{
			int mid = (i+j)/2;
			return getsmallerTimestamp(getEarliest(i,mid,taskId),getEarliest(mid+1,j,taskId));
		}
	}
	

	private int getsmallerTimestamp(int earliest, int earliest2) {
		if(getTimeStamp(earliest) == 0) {
			return earliest2;
		}
		else if(getTimeStamp(earliest2) == 0) {
			return earliest;
		}
		else if(getTimeStamp(earliest) <= getTimeStamp(earliest2)) {
			return earliest;
		}
		else {
			return earliest2;
		}
	}

	private int getTimeStamp(int earliest) {
		String line = readNexLine(earliest);
		rewindFilePontersOneLine(earliest);
		if(line !=null) {
			/* using number instead of time stamp for easy testing. in real scenario I will 
			get epoch time from string and use that to compare
			*/
			return Integer.parseInt(line.split(" ")[0]); 
		}
		else {
			return 0;
		}
	}

	private void moveFilePointertoNextMatchedTaskId(int i, String taskId) {
		// for simplicity assuming every line contains task id so simple moving to next line
		// in real scenario keep moving file pointer until desired task id is found here
		// NVM - I actually implemented this part as well
		String line = readNexLine(i);
		while(line !=null) {
			if(line.split(" ")[1].contentEquals(taskId)){
				break;
			}
			line = readNexLine(i);
		}
	}

	private void rewindFilePontersOneLine(int i) {
		try {
			filePointerList.get(i).reset();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void printFileContent(int i, String[] files) {
		String line = readNexLine(i);
		if(line != null) {
			System.out.println(line+": FILE_NAME ["+files[i]+"]");
		}
	}

	private String readNexLine(int i) {
		try {
			filePointerList.get(i).mark(1000);
			return filePointerList.get(i).readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private boolean allFilePointerEndofLine() {
		for(int i = 0 ; i<filePointerList.size() ;i ++) {
			if(readNexLine(i) != null) {
				rewindFilePontersOneLine(i);
				return false;
			}
		}
		return true;
	}

	private void openFilesAndPutinFilePointerlist(String [] files) throws FileNotFoundException {
		for(int i= 0; i < files.length;i++) {
			filePointerList.add(new BufferedReader(new FileReader(files[i])));
		}		
	}
	
	private void closeFiles() {
		for(int i= 0; i < filePointerList.size();i++) {
			try {
				filePointerList.get(i).close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
