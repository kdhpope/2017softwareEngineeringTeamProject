import java.util.ArrayList;
import java.util.StringTokenizer;


public class compare {
	ArrayList<String> left,right;
	private ArrayList<String> inputText(ArrayList<String> List){
		
		
		
		return List;
	}
	private void setParagraph(Paragraph para,String text){
		//System.out.print(text.getText());
	}
	public void compareCode(){

		
	
		left = new ArrayList<String>();
		right = new ArrayList<String>();
		
		StringTokenizer inputLeft = new StringTokenizer(GUI1.getLeftPanelText()); 
		StringTokenizer inputRight = new StringTokenizer(GUI1.getRightPanelText()); 
		
		while(inputLeft.hasMoreTokens()) {  
            // nextToken ���ڿ��� �и��� ��ū(�и��� ��Ʈ���� �־��ݴϴ�)  
            left.add(inputLeft.nextToken("\n"));  
        }  
		while(inputRight.hasMoreTokens()) {  
            // nextToken ���ڿ��� �и��� ��ū(�и��� ��Ʈ���� �־��ݴϴ�)  
            right.add(inputRight.nextToken("\n"));  
        }  


		
		
		//text = getText();
		//setParagraph(this.left,text);
		
		
	}
}
