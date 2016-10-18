import java.util.*;

class DividePosts {
    public static int dividePosts(int[] posts, int k) {
        /*
        we will find a taget between value 1 --> sum/k in such a way that
        array can be divided in to k or moresub array. if division >=k
        we can find bigger target. else look for smaller target so that division is atleast ==k
        */
        int left = 1;
        int right = Arrays.stream(posts).sum()/k;
        while (left < right) {
            int mid = left + (right - left + 1)/2;
            int sum = 0;
            int subArraySize = 0;

            for (int post: posts) {
                sum += post;
                if(sum >= mid) {
                    sum = 0;
                    subArraySize++;
                }
            }
            // search on right side inclusive the one you found since you may not have other result
            if(subArraySize >=k)
                left = mid;
            else
                right = mid - 1;
        }
        return left;
    }
    public static void main( String args[] ) {
        // Driver code

        int[] days = {1000,2000,3000,4000,5000};
        int nodes = 3;
        System.out.println("The master node was assigned " +  dividePosts(days, nodes) + " posts");
    }
}