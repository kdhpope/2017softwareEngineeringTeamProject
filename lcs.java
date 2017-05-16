import java.util.ArrayList;


public class lcs {
	private int[][] D; 
	private int[][] via;//0=diagonal 1=left 2=up
	private static ArrayList<String> LCS = new ArrayList<String>();
	
	public void findLcs(ArrayList<String> left,ArrayList<String> right){
		D = new int[left.size()+1][right.size()+1];
		via = new int[left.size()+1][right.size()+1];
		int i,j = 0;
		
		for(i=1;i<=left.size()+1;i++){
			for(j=1;j<=right.size()+1;j++){
				if(left.get(i).equals(right.get(i))) {
					D[i][j] = D[i-1][j-1] + 1;
					via[i][j] = 0;
				}
				else if(D[i-1][j] >= D[i][j-1]) {
					D[i][j] = D[i-1][j];
					via[i][j] = 2;
				}
				else {
					D[i][j] = D[i][j-1];
					via[i][j] = 1;
				}
			}
		}
		i--;
		j--;
		while(i!=0 && j!=0){
			if(via[i][j] == 0){
		//		LCS.seq.add(1, left.seq.get(i));
				i--;j--;
			}
			else if(via[i][j] == 1){
				j--;
			}
			else if(via[i][j] == 2){
				i--;
			}
			
		}
		
		
	}
	
	
}
