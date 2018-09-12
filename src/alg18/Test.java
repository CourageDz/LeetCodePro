package alg18;

public class Test {
        public static void main(String[] args) {
            int y=0;
            //注意"="是赋值,"=="才是相等
            y=++y;// y==0,++y==y+1; 结果y=++y == y+1 == 0+1 ==1
            y=++y;// y==1,++y==y+1; 结果y=++y == y+1 == 1+1 ==2
            y=++y;// y==2,++y==y+1; 结果y=++y == y+1 == 2+1 ==3
            y=++y;// y==3,++y==y+1; 结果y=++y == y+1 == 3+1 ==4
            y=++y;// y==4,++y==y+1; 结果y=++y == y+1 == 4+1 ==5
            System.out.println("y="+y);//5
            int i =0;
            // i==0,i++==0; 结果i=i++ == (记住先赋值后运算)i=i,i=i+1(由于是i++运算这里我们输出的i只取先赋值的结果也就是i=i)
            i=i++;
            i=i++;
            i=i++;
            i=i++;
            i=i++;
            System.out.println("i="+i);//0
            System.out.println("================");//1
            int []nums ={1,2,3,4};
//            System.out.println(nums[i++]);
            System.out.println(nums[++i]);


        }

}
