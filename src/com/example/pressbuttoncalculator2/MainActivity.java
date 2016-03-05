package com.example.pressbuttoncalculator2;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

	
	static int currentValue1;
	static int currentValue2;
	static String tempSymbol=""; //Holds the symbol whether it was + - / * USED FOR THE = BUTTOn
	static int operatorCount=0; // This is to tell when the operator has been pressed.
	static int numberOfClick1=0; //Detects how many clicks were used to determine 1 form 10
	static int numberOfClick2=0; //This detects how many clicks for the 2nd number
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//setContentView MUST BE HERE IN ORDER FOR IT TO WORK
        
        final TextView number1View=(TextView) findViewById(R.id.textView1);
        
        Button buttonNo1=(Button) findViewById(R.id.button1);
        Button buttonNo2=(Button) findViewById(R.id.button2);
        Button buttonNo3=(Button) findViewById(R.id.button3);
        Button buttonNo4=(Button) findViewById(R.id.button4);
        Button buttonNo5=(Button) findViewById(R.id.button5);
        Button buttonNo6=(Button) findViewById(R.id.button6);
        Button buttonNo7=(Button) findViewById(R.id.button7);
        Button buttonNo8=(Button) findViewById(R.id.button8);
        Button buttonNo9=(Button) findViewById(R.id.button9);
        Button buttonNoZ=(Button) findViewById(R.id.button10);
        //Button buttonNoDec=(Button) findViewById(R.id.button11);
        Button buttonNoEqual=(Button) findViewById(R.id.button12);
        Button buttonClear=(Button) findViewById(R.id.button13);
        Button buttonAdd=(Button) findViewById(R.id.button14);
        Button buttonSubtract=(Button) findViewById(R.id.button15);
        Button buttonMultiply=(Button) findViewById(R.id.button16);
        Button buttonDivide=(Button) findViewById(R.id.button17);
        
        
        
        
        buttonNoEqual.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				operatorCount++;
				
				double currentValueFinal = 0;

				if(tempSymbol==""){				//This is for when you enter only one number without an operator. tempSymbol is "" by default
					currentValueFinal=(double)currentValue1;
					String stringCurrentValueFinal=String.valueOf(currentValueFinal+ " = " + currentValueFinal);
					number1View.setText(stringCurrentValueFinal);
				}
				if (tempSymbol=="+"){
					 currentValueFinal=(double)currentValue1 + (double)currentValue2;
					 String stringCurrentValueFinal=String.valueOf(currentValue1 + " "+tempSymbol +" "+ currentValue2 + " = " + currentValueFinal);
					 number1View.setText(stringCurrentValueFinal);
				}
				
				if(tempSymbol=="-"){
					
					currentValueFinal=(double)currentValue1 - (double)currentValue2;
					String stringCurrentValueFinal=String.valueOf(currentValue1 +" "+ tempSymbol +" "+ currentValue2 + " = " + currentValueFinal);
					number1View.setText(stringCurrentValueFinal);
				}
				
				if(tempSymbol=="*"){
					currentValueFinal=(double)currentValue1*(double)currentValue2;
					String stringCurrentValueFinal=String.valueOf(currentValue1 +" "+ tempSymbol +" "+ currentValue2 + " = " + currentValueFinal);
					number1View.setText(stringCurrentValueFinal);
				}
				if(tempSymbol=="/"){
					
					currentValueFinal=(double)currentValue1/(double)currentValue2;
					String stringCurrentValueFinal=String.valueOf(currentValue1 +" "+ tempSymbol +" "+ currentValue2 + " = " + currentValueFinal);
					number1View.setText(stringCurrentValueFinal);
				}
				
				//String stringCurrentValueFinal=String.valueOf(currentValue1 + tempSymbol + currentValue2 + " = " + currentValueFinal);
				//number1View.setText(stringCurrentValueFinal);
				//currentValue1=Integer.parseInt(stringCurrentValueFinal);	//So that after you press =, the equal value becomes currentValue1
			}

        
        	
        	
        });
        	
        	
        buttonClear.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				currentValue1=0;
				currentValue2=0;
				tempSymbol="";
				operatorCount=0;
				numberOfClick1=0;
				numberOfClick2=0;
				number1View.setText("Cleared");
				
			}
        
        
        
        
        
        
        
        
        
        });
        
        	
        	
        	
          buttonAdd.setOnClickListener(new OnClickListener(){				//THE ADD BUTTOn

			@Override
			public void onClick(View arg0) {
				operatorCount++;
				
				
				String result=String.valueOf(currentValue1);
				number1View.setText(result + " + ");	
				tempSymbol="+";
			}
        });
        
       
        
        
        buttonSubtract.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				operatorCount++;
				
				
				String result=String.valueOf(currentValue1);
				number1View.setText(result + " - ");	
				tempSymbol="-";
			}		
        });
          
        buttonMultiply.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				operatorCount++;
				
				
				String result=String.valueOf(currentValue1);
				number1View.setText(result + " * ");	
				tempSymbol="*";
			}	
        });  
        
        
        buttonDivide.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				operatorCount++;
				
				
				String result=String.valueOf(currentValue1);
				number1View.setText(result + " / ");	
				tempSymbol="/";
			}	
        });  
        
       
        
          
          buttonNo1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				
				if ((operatorCount<1)&&(numberOfClick1<1)){ 			//If it is the very first number, just place the 1 as currentValue1
						currentValue1=1;
						String result=String.valueOf(currentValue1);
						number1View.setText(result);
						numberOfClick1++;
				}
				else if (operatorCount<1){							//If it has more than number aka more than one click, then it will add a 1 at the end
					String ScurrentValue1=String.valueOf(currentValue1+"1");
					 currentValue1 = Integer.parseInt(ScurrentValue1);
					number1View.setText(ScurrentValue1);
					
				}			
				
				else if ((operatorCount==1)&&(numberOfClick2<1))	//If there is an operator added(+-/*) then operatorCount will be 1. numberOfClick2 will be at 0 so it will see it as the first number
					{
					currentValue2=1;
					String result=String.valueOf(currentValue1 +" "+ tempSymbol +" "+ currentValue2);
					number1View.setText(result);
					numberOfClick2++;
					}
				else if ((operatorCount==1)&&(numberOfClick2>=1)){    //numberOfClick2 will have been incremented so the program will know that user wants to add a "1" at the end
					String ScurrentValue2=String.valueOf(currentValue2+"1");
					String result=String.valueOf(currentValue1 +" "+ tempSymbol +" "+ ScurrentValue2);
					currentValue2=Integer.parseInt(ScurrentValue2);
					number1View.setText(result);
				}
				
			}});
        
        
             
        
          buttonNo2.setOnClickListener(new OnClickListener(){

  			@Override
  			public void onClick(View arg0) {
  				
  				if ((operatorCount<1)&&(numberOfClick1<1)){ //If there is no operator added first number
  						currentValue1=2;
  						String result=String.valueOf(currentValue1);
  						number1View.setText(result);
  						numberOfClick1++;
  				}
  				else if (operatorCount<1){
  					String ScurrentValue1=String.valueOf(currentValue1+"2");
  					 currentValue1 = Integer.parseInt(ScurrentValue1);
  					number1View.setText(ScurrentValue1);
  					
  				}
  				
  				else if ((operatorCount==1)&&(numberOfClick2<1))//If there is no operator added for second number. EQUAL SIGN ACTS AS OPERATOR+
  					{
  					currentValue2=2;
  					String result=String.valueOf(currentValue1 +" "+ tempSymbol +" "+ currentValue2);
  					number1View.setText(result);
  					numberOfClick2++;
  					}
  				else if ((operatorCount==1)&&(numberOfClick2>=1)){
  					String ScurrentValue2=String.valueOf(currentValue2+"2");
  					String result=String.valueOf(currentValue1 +" "+ tempSymbol +" "+ ScurrentValue2);
  					currentValue2=Integer.parseInt(ScurrentValue2);
  					number1View.setText(result);
  					
  				
  				}
  			}});
          
        

          buttonNo3.setOnClickListener(new OnClickListener(){

  			@Override
  			public void onClick(View arg0) {
  				
  				if ((operatorCount<1)&&(numberOfClick1<1)){ //If there is no operator added first number
  						currentValue1=3;
  						String result=String.valueOf(currentValue1);
  						number1View.setText(result);
  						numberOfClick1++;
  				}
  				else if (operatorCount<1){
  					String ScurrentValue1=String.valueOf(currentValue1+"3");
  					 currentValue1 = Integer.parseInt(ScurrentValue1);
  					number1View.setText(ScurrentValue1);
  					
  				}
  				
  				else if ((operatorCount==1)&&(numberOfClick2<1))//If there is no operator added for second number. EQUAL SIGN ACTS AS OPERATOR+
  					{
  					currentValue2=3;
  					String result=String.valueOf(currentValue1 +" "+ tempSymbol +" "+ currentValue2);
  					number1View.setText(result);
  					numberOfClick2++;
  					}
  				else if ((operatorCount==1)&&(numberOfClick2>=1)){
  					String ScurrentValue2=String.valueOf(currentValue2+"3");
  					String result=String.valueOf(currentValue1 +" "+ tempSymbol +" "+ ScurrentValue2);
  					currentValue2=Integer.parseInt(ScurrentValue2);
  					number1View.setText(result);
  					
  				
  				}
  			}});
        
        
          buttonNo4.setOnClickListener(new OnClickListener(){

  			@Override
  			public void onClick(View arg0) {
  				
  				if ((operatorCount<1)&&(numberOfClick1<1)){ //If there is no operator added first number
  						currentValue1=4;
  						String result=String.valueOf(currentValue1);
  						number1View.setText(result);
  						numberOfClick1++;
  				}
  				else if (operatorCount<1){
  					String ScurrentValue1=String.valueOf(currentValue1+"4");
  					 currentValue1 = Integer.parseInt(ScurrentValue1);
  					number1View.setText(ScurrentValue1);
  					
  				}
  				
  				else if ((operatorCount==1)&&(numberOfClick2<1))//If there is no operator added for second number. EQUAL SIGN ACTS AS OPERATOR+
  					{
  					currentValue2=4;
  					String result=String.valueOf(currentValue1 +" "+ tempSymbol +" "+ currentValue2);
  					number1View.setText(result);
  					numberOfClick2++;
  					}
  				else if ((operatorCount==1)&&(numberOfClick2>=1)){
  					String ScurrentValue2=String.valueOf(currentValue2+"4");
  					String result=String.valueOf(currentValue1 +" "+ tempSymbol +" "+ ScurrentValue2);
  					currentValue2=Integer.parseInt(ScurrentValue2);
  					number1View.setText(result);
  					
  				
  				}
  			}});
        
         
          
          buttonNo5.setOnClickListener(new OnClickListener(){

  			@Override
  			public void onClick(View arg0) {
  				
  				if ((operatorCount<1)&&(numberOfClick1<1)){ //If there is no operator added first number
  						currentValue1=5;
  						String result=String.valueOf(currentValue1);
  						number1View.setText(result);
  						numberOfClick1++;
  				}
  				else if (operatorCount<1){
  					String ScurrentValue1=String.valueOf(currentValue1+"5");
  					 currentValue1 = Integer.parseInt(ScurrentValue1);
  					number1View.setText(ScurrentValue1);
  					
  				}
  				
  				else if ((operatorCount==1)&&(numberOfClick2<1))//If there is no operator added for second number. EQUAL SIGN ACTS AS OPERATOR+
  					{
  					currentValue2=5;
  					String result=String.valueOf(currentValue1 +" "+ tempSymbol +" "+ currentValue2);
  					number1View.setText(result);
  					numberOfClick2++;
  					}
  				else if ((operatorCount==1)&&(numberOfClick2>=1)){
  					String ScurrentValue2=String.valueOf(currentValue2+"5");
  					String result=String.valueOf(currentValue1 +" "+ tempSymbol +" "+ ScurrentValue2);
  					currentValue2=Integer.parseInt(ScurrentValue2);
  					number1View.setText(result);
  					
  				
  				}
  			}});
        
        
          buttonNo6.setOnClickListener(new OnClickListener(){

  			@Override
  			public void onClick(View arg0) {
  				
  				if ((operatorCount<1)&&(numberOfClick1<1)){ //If it is the very first number, just place the 1
  						currentValue1=6;
  						String result=String.valueOf(currentValue1);
  						number1View.setText(result);
  						numberOfClick1++;
  				}
  				else if (operatorCount<1){					
  					String ScurrentValue1=String.valueOf(currentValue1+"6");
  					 currentValue1 = Integer.parseInt(ScurrentValue1);
  					number1View.setText(ScurrentValue1);
  					
  				}
  				
  				else if ((operatorCount==1)&&(numberOfClick2<1))//If there is no operator added for second number. EQUAL SIGN ACTS AS OPERATOR+
  					{
  					currentValue2=2;
  					String result=String.valueOf(currentValue1 +" "+ tempSymbol +" "+ currentValue2);
  					number1View.setText(result);
  					numberOfClick2++;
  					}
  				else if ((operatorCount==1)&&(numberOfClick2>=1)){
  					String ScurrentValue2=String.valueOf(currentValue2+"6");
  					String result=String.valueOf(currentValue1 +" "+ tempSymbol +" "+ ScurrentValue2);
  					currentValue2=Integer.parseInt(ScurrentValue2);
  					number1View.setText(result);
  					
  				
  				}
  			}});
        
        
          buttonNo7.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				
				if ((operatorCount<1)&&(numberOfClick1<1)){ 			//If it is the very first number, just place the 1 as currentValue1
						currentValue1=7;
						String result=String.valueOf(currentValue1);
						number1View.setText(result);
						numberOfClick1++;
				}
				else if (operatorCount<1){							//If it has more than number aka more than one click, then it will add a 1 at the end
					String ScurrentValue1=String.valueOf(currentValue1+"7");
					 currentValue1 = Integer.parseInt(ScurrentValue1);
					number1View.setText(ScurrentValue1);
					
				}
				
				else if ((operatorCount==1)&&(numberOfClick2<1))	//If there is an operator added(+-/*) then operatorCount will be 1. numberOfClick2 will be at 0 so it will see it as the first number
					{
					currentValue2=7;
					String result=String.valueOf(currentValue1 +" "+ tempSymbol +" "+ currentValue2);
					number1View.setText(result);
					numberOfClick2++;
					}
				else if ((operatorCount==1)&&(numberOfClick2>=1)){    //numberOfClick2 will have been incremented so the program will know that user wants to add a "1" at the end
					String ScurrentValue2=String.valueOf(currentValue2+"7");
					String result=String.valueOf(currentValue1 +" "+ tempSymbol +" "+ ScurrentValue2);
					currentValue2=Integer.parseInt(ScurrentValue2);
					number1View.setText(result);
					
				
				}
			}});
        
    
          buttonNo8.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				
				if ((operatorCount<1)&&(numberOfClick1<1)){ 			//If it is the very first number, just place the 1 as currentValue1
						currentValue1=8;
						String result=String.valueOf(currentValue1);
						number1View.setText(result);
						numberOfClick1++;
				}
				else if (operatorCount<1){							//If it has more than number aka more than one click, then it will add a 1 at the end
					String ScurrentValue1=String.valueOf(currentValue1+"8");
					 currentValue1 = Integer.parseInt(ScurrentValue1);
					number1View.setText(ScurrentValue1);
					
				}
				
				else if ((operatorCount==1)&&(numberOfClick2<1))	//If there is an operator added(+-/*) then operatorCount will be 1. numberOfClick2 will be at 0 so it will see it as the first number
					{
					currentValue2=8;
					String result=String.valueOf(currentValue1 +" "+ tempSymbol +" "+ currentValue2);
					number1View.setText(result);
					numberOfClick2++;
					}
				else if ((operatorCount==1)&&(numberOfClick2>=1)){    //numberOfClick2 will have been incremented so the program will know that user wants to add a "1" at the end
					String ScurrentValue2=String.valueOf(currentValue2+"8");
					String result=String.valueOf(currentValue1 +" "+ tempSymbol +" "+ ScurrentValue2);
					currentValue2=Integer.parseInt(ScurrentValue2);
					number1View.setText(result);
					
				
				}
			}});
        
        
          buttonNo9.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				
				if ((operatorCount<1)&&(numberOfClick1<1)){ 			//If it is the very first number, just place the 1 as currentValue1
						currentValue1=9;
						String result=String.valueOf(currentValue1);
						number1View.setText(result);
						numberOfClick1++;
				}
				else if (operatorCount<1){							//If it has more than number aka more than one click, then it will add a 1 at the end
					String ScurrentValue1=String.valueOf(currentValue1+"9");
					 currentValue1 = Integer.parseInt(ScurrentValue1);
					number1View.setText(ScurrentValue1);
					
				}
				
				else if ((operatorCount==1)&&(numberOfClick2<1))	//If there is an operator added(+-/*) then operatorCount will be 1. numberOfClick2 will be at 0 so it will see it as the first number
					{
					currentValue2=9;
					String result=String.valueOf(currentValue1 +" "+ tempSymbol +" "+ currentValue2);
					number1View.setText(result);
					numberOfClick2++;
					}
				else if ((operatorCount==1)&&(numberOfClick2>=1)){    //numberOfClick2 will have been incremented so the program will know that user wants to add a "1" at the end
					String ScurrentValue2=String.valueOf(currentValue2+"9");
					String result=String.valueOf(currentValue1 +" "+ tempSymbol +" "+ ScurrentValue2);
					currentValue2=Integer.parseInt(ScurrentValue2);
					number1View.setText(result);
					
				
				}
			}});
        
     
          
          buttonNoZ.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				
				if ((operatorCount<1)&&(numberOfClick1<1)){ 			//If it is the very first number, just place the 1 as currentValue1
						currentValue1=0;
						String result=String.valueOf(currentValue1);
						number1View.setText(result);
						numberOfClick1++;
				}
				else if (operatorCount<1){							//If it has more than number aka more than one click, then it will add a 1 at the end
					String ScurrentValue1=String.valueOf(currentValue1+"0");
					 currentValue1 = Integer.parseInt(ScurrentValue1);
					number1View.setText(ScurrentValue1);
					
				}
				
				else if ((operatorCount==1)&&(numberOfClick2<1))	//If there is an operator added(+-/*) then operatorCount will be 1. numberOfClick2 will be at 0 so it will see it as the first number
					{
					currentValue2=0;
					String result=String.valueOf(currentValue1 +" "+ tempSymbol +" "+ currentValue2);
					number1View.setText(result);
					numberOfClick2++;
					}
				else if ((operatorCount==1)&&(numberOfClick2>=1)){    //numberOfClick2 will have been incremented so the program will know that user wants to add a "1" at the end
					String ScurrentValue2=String.valueOf(currentValue2+"0");
					String result=String.valueOf(currentValue1 +" "+ tempSymbol +" "+ ScurrentValue2);
					currentValue2=Integer.parseInt(ScurrentValue2);
					number1View.setText(result);
					
				
				}
			}});
        
        
        
    }


   
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
