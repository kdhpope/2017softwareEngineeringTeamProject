
public class lcs {
	private int[][] D; 
	private int[][] via;//0=diagonal 1=left 2=up
	private static Paragraph LCS;
	
	public void lcs(Paragraph left,Paragraph right){
		D = new int[left.line+1][right.line+1];
		via = new int[left.line+1][right.line+1];
		int i,j = 0;
		
		for(i=1;i<=left.line+1;i++){
			for(j=1;j<=right.line+1;j++){
				if(left.seq.get(i).equals(right.seq.get(j))){
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
				LCS.seq.add(1, left.seq.get(i));
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
