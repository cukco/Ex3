import java.util.Scanner;
public class Ex43 {
    public static void SelectionSort(int[] arr){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            int max = i;
            for(int j=i+1;j<n;j++){
                if(arr[j] > arr[max]){
                    max=j;
                }
            }
            if(max!=i){
                int temp=arr[i];
                arr[i]=arr[max];
                arr[max]=temp;
            }
        }
    }
    public static void BinarySearch(int[] arr,int x){
        int n=arr.length;
        int low=n-1;
        int high=0;
        while(low >= high){
            int mid=(low+high)/2;
            if(arr[mid]==x){
                System.out.printf("Tìm kiếm nhị phân: Số %d có tại vị trí %d",x,mid);
                return;
            }else if(arr[mid] < x){
                low=mid-1;
            }else high=mid+1;
        }
        System.out.printf("Không tìm thấy");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = sc.nextInt();
        System.out.print("Nhập các phần tử của mảng:\n");
        int[] mang = new int[n];
        for(int i=1;i<=n;i++){
            System.out.printf("Phần tử thứ %d: ",i);
            mang[i-1] = sc.nextInt();
        }
        SelectionSort(mang);
        System.out.println("Mảng sau khi sắp xếp giảm dần");
        for(int i=0;i<n;i++){
            System.out.print(mang[i]+" ");
        }
        System.out.print("\nNhập số cần tìm: ");
        int x=sc.nextInt();
        boolean flag=false;
        for(int i=0;i<n;i++){
            if(mang[i]==x){
                System.out.printf("Tìm kiếm tuyến tính: Số %d có tại vị trí %d\n",x,i);
                flag=true;
                break;
            }
        }
        if(!flag)System.out.print("Không tìm thấy\n");
        BinarySearch(mang,x);
    }
}
