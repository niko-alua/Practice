import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);

    private static int u_o_w_calc(int[] surf_arr) { //Function to calculate the water that should be filled in each array element
        int u_o_w = 0;       //units of water
        int l = surf_arr.length;  //array length
        int[] left_surf = new int[l];  //array from the left of the actual array
        int[] right_surf = new int[l];   //array from the right of the actual array


        //Storing into the new array from the left of the actual array
        left_surf[0] = surf_arr[0];
        for(int i = 1; i < l; i++){
            left_surf[i] = Math.max(left_surf[i - 1], surf_arr[i]);
        }
        //Storing into the new array from the right of the actual array
        right_surf[l - 1] = surf_arr[l - 1];
        for(int i = l - 2; i >= 0; i--) {
            right_surf[i] = Math.max(right_surf[i + 1], surf_arr[i]);
        }

        //Summing the water units of the each array in the u_o_w attribute
        for(int i = 0; i < l; i++) {
            u_o_w += Math.min(left_surf[i], right_surf[i]) - surf_arr[i];
        }

        return u_o_w;
    }

    public static void main(String[] args) {


        // the program is written to calculate different types of surfaces
        System.out.println("Length of surface array: ");
        int size = in.nextInt();

        int u_of_w = 0;  //units of water

        int[] surf_arr = new int [size]; //array storing the surface amount

        System.out.println("Surface array elements:");


        //filling in the array
        for(int i = 0; i < size; i++){
            surf_arr[i] = in.nextInt();
        }

        u_of_w = u_o_w_calc(surf_arr); //finding water units by function

        System.out.print("How many units of water is needed to fill in the holes of surface: " + "\n" + u_of_w);
    }
}
