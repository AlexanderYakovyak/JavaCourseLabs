public class Task1_6 {
    public static void main(String[] args){
        StringBuffer sb = new StringBuffer("Some sample string |||| ");
        String another = "that we use to ilustrate the methods of class StringBuffer";

        //Only updating the StringBuffer, not creating a new String
        sb.append(another);

        System.out.println("Modified string: ");
        System.out.println(sb);
    }
}
