package week1to8;
class List{
    int data;
    List next;

    public List(int n){
        this.data=n;
        this.next=null;
    }
}

public class Week2{
    static List temp;
    static String display(List list)
    {
        String res="";
        while(list != null)
        {
            res+= list.data + " ";
            list = list.next;
        }
        return res;
    }

    static List merge(List arr[], int k)
    {
        List temp = arr[0];
        for (int i = 1; i <k; i++)
        {
            while(temp.next!=null)
            {
                temp= temp.next;
            }
            temp.next=arr[i];
        }
        return arr[0];
    }
    static List sort(List list) {
        List mainList = list;
        List temp ;
        while(mainList.next!=null) {
            temp = mainList.next;
            while(temp!=null) {
                if(temp.data>mainList.data) {
                    int num = temp.data;
                    temp.data=mainList.data;
                    mainList.data=num;
                }
                temp=temp.next;
            }
            mainList = mainList.next;
        }
        return list;
    }
    static void evaluateSum(List list){
        List temp =list;
        int positiveSum =0;
        int negativeSum =0;
        while(temp!=null) {
            if(temp.data>0) {
                positiveSum += temp.data;
            }
            else if(temp.data<0) {
                negativeSum+= Math.abs(temp.data);
            }
            temp=temp.next;
        }
        if(positiveSum>negativeSum) {
            System.out.println("The sum of the array at any given point will be positive");
        }
        else {
            System.out.println("Since there are more negative values than positive the total sum of the array may not be positive at all points");
        }
    }
    public static void main(String[] args) {

        int k=4;
        List arr[]= new List[k];


        arr[0] = new List(5);
        arr[0].next = new List(7);
        arr[0].next.next = new List(8);
        arr[0].next.next.next = new List(9);

        arr[1] = new List(1);
        arr[1].next = new List(2);
        arr[1].next.next = new List(3);
        arr[1].next.next.next = new List(6);

        arr[2] = new List(-5);
        arr[2].next = new List(-10);
        arr[2].next.next = new List(10);
        arr[2].next.next.next = new List(11);

        arr[0]=merge(arr, k);
        arr[0]=sort(arr[0]);
        String res=display(arr[0]);
        System.out.println(res);
        evaluateSum(arr[0]);
    }
}