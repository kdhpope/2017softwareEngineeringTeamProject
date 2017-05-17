import javax.swing.JTextPane;

public class Merge {
	
	int start;
	int end;

	void mergeToRight(JTextPane leftPane,JTextPane rightPane){
		  
    	  String temp;
    	  int position=rightPane.getCaretPosition();
      	  if(position<=end&&start<=position){
      		  rightPane.select(start,end);
      		  temp=rightPane.getSelectedText();
      		  leftPane.select(start,end);
      		  leftPane.replaceSelection(temp);
      	  }
      	
	}
	
	void mergeToLeft(JTextPane leftPane,JTextPane rightPane){
		  
  	  String temp;
  	  int position=rightPane.getCaretPosition();
    	  if(position<=end&&start<=position){
    		  rightPane.select(start,end);
    		  temp=rightPane.getSelectedText();
    		  leftPane.select(start,end);
    		  leftPane.replaceSelection(temp);
    	  }
    	
	}
}
