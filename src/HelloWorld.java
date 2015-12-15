

public class HelloWorld {
	public static void main(String[] args) {
		
		System.out.println("Hello World");
		Integer[] arr = new Integer[4];
			arr[1] = 1;
			arr[2] = 1;
			arr[3] = 1;
			arr[0] = 1;
		for(int i= 0; i<4;i++) {
			System.out.println(arr[i]);
		}
		for(int i:arr){
			System.out.println(i);
		}
		
		
		Integer[][] twod = {{1,2,3},{4,5,6}};
		for(Integer[] i:twod) {
			for(Integer j:i) {
				System.out.println(j);
			}
		}
		
	}
}
