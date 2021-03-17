// public class MyClass {
//     public static void main(String[] args) {
//         int myNumbers[] = {1, 2, 3};
//         try {
//             System.out.println(myNumbers[10]);
//         }catch(Exception e){
//             System.out.println(e.getMessage());
//             System.out.println(myNumbers[3]);
//         }//event error or not still execute in finally
//         finally {
//             System.out.println("Bye!");
//         }
//     }
// }
// public class MyClass {
//     public static void main(String[] args) {
//         int myNumbers[] = {1, 2, 3};
//         try {
//             System.out.println(myNumbers[10]);
//             // specific first

//         }
//         catch(IndexOutOfBoundsException e){
//             System.out.println(e.getMessage());
//         }
//         catch(Exception e){

//             System.out.println(e.getMessage());
//             System.out.println(myNumbers[3]);
//         }
//         finally{
//             System.out.println("bye!");
//         }
//     }
// }
//throw error mean end at throw(it is real error)
//throws can have this and that error