public class Demo2 {
       public static void main(String [] args) {
           int num1 = 9;
           int num2 = 5;
           int result = num1 - num2;
           System.out.println(result);

           if(num1 > num2){
               System.out.println("num1 is greater");
           }
           else if(num1 < num2){
               System.out.println("num2 is greater");
           }
           else {
               System.out.println("Both are equal");
           }
           int result2 = 0;
           result2 = num1>0?5:10;
           System.out.println(result2);
       }
}
