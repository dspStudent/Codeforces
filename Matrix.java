import java.io.*;
import java.util.*;
public class Matrix<T> {
	T mat[][];
	T idMat[][];
	Matrix(T n, T m){
		mat=new T[n][m];
		idMat=new T[n][m];
		for(int i=0;i<n;i++){
			idMat[i][i]=1;
		}
	}
	public Matrix matPower(T a[][], int ){
		int n=a.length, m=a[0].length;
		Matrix res=new Matrix(n, m);

	}
	public Matrix matMul(T a[][]){
		int n=a.length, m=a[0].length;
		int thisn=this.mat.length, thism=this.mat[0].length;
		Matrix res=new Matrix(thisn, m);
		int c[][]=new T[thisn][m];
		try{
			if(thism!=n){
				throw new Exception("cant be multiplied");
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
		for(int i=0;i<thisn;i++){
			for(int j=0;j<m;j++){
				for(int k=0;k<n;k++){
					res.mat[i][j]+=this.mat[k][j]*a[i][k];
				}
			}
		}
		return res;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuffer out = new StringBuffer();
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2=new StringTokenizer(br.readLine());
            int a[][]=new int[n][n];
            a[0][0]=Integer.parseInt(st1.nextToken());
            a[0][1]=Integer.parseInt(st1.nextToken());
            a[1][0]=Integer.parseInt(st2.nextToken());
            a[1][1]=Integer.parseInt(st2.nextToken());
            for(int i[]:a)System.out.println(Arrays.toString(i));
		}
		System.out.println(out);
	}
}