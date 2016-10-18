class FriendCircles {
    static boolean[][] friends = new boolean[][] {
        {true,false,false,false},
        {false,true,false,false},
        {false,false,true,false},
        {false,false,false,true}
    };

    static void dfsWithSink(int i, int j) {
        if(!friends[i][j]) return;
        friends[i][j] = false;
        if(j > 0) dfsWithSink(i, j-1);
        if(i > 0) dfsWithSink(i-1, j);
        if(j < friends[i].length-1) dfsWithSink(i, j+1);
        if(i <friends.length - 1) dfsWithSink(i+1, j);
    }

    public static void main(String args[]) {
        int n = 4;
        int circles = 0;
        for(int i = 0; i < n; i++) {
            if(friends[i][i]) {
                circles++;
                dfsWithSink(i ,i);
            }
        }
        System.out.println("Number of friends circles: " + circles);
    }
}