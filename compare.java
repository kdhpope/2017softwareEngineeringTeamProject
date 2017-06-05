import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextPane;


public class compare {
	ArrayList<String> left,right;
	
	private void setParagraph(Paragraph para,String text){
		//System.out.print(text.getText());
	}
	public void compareCode(){
		int k, i, j, t;
		int sw;
		
		String text;
		
		left = new ArrayList<String>();
		right = new ArrayList<String>();
		
		
		//text = getText();
		//setParagraph(this.left,text);
				
		k = i = j = t = 0;
		sw = -1;
		
		while(true) {
			if(lcs.getLeftLCS(k) == i && lcs.getRightLCS(k) == j) {
				if(sw != 0) {
					ParagraphList.leftParagraphList.add(new Paragraph());
				}
				ParagraphList.leftParagraphList.get(t).setSeq(left.get(lcs.getLeftLCS(i)));
				ParagraphList.rightParagraphList.get(t).setSeq(right.get(lcs.getRightLCS(i)));
				k++;
				i++;
				j++;
			}
			else if(lcs.getLeftLCS(k) == i && lcs.getRightLCS(k) != j) {
				if(sw != 1) {
					sw = 1;
					ParagraphList.leftParagraphList.add(new Paragraph());
				}
				ParagraphList.leftParagraphList.get(t).setSeq("\n");
				ParagraphList.rightParagraphList.get(t).setSeq(right.get(lcs.getRightLCS(i)));
				j++;
			}
			else {
				if(sw != 2) {
					sw = 2;
					ParagraphList.leftParagraphList.add(new Paragraph());
				}
				ParagraphList.leftParagraphList.get(t).setSeq(left.get(lcs.getLeftLCS(i)));
				ParagraphList.rightParagraphList.get(t).setSeq("\n");
				i++;
			}
		}
	}
}
