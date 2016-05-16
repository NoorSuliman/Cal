package calculator;


import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class calculator extends Application {
	static  ArrayList<String> eq=new ArrayList<String>();
	TextField output=new  TextField();
	 //  private double answer;
	
public calculator() {
        // TODO Auto-generated constructor stub
    }
private static final Button[][] operation={{ new Button("%"),new Button( "+") },
            { new Button("√"),new Button( "-")},
            {new Button("3√"), new Button("*") },
            { new Button("="),new Button( "/") }

        };
private static final  Button[][] numbers={{ new Button("1"), new Button("2"),new Button ("3") },
            { new Button("4"), new Button("5"), new Button("6")},
            { new Button("7"), new Button("8"), new Button("9") },
            { new Button("0"), new Button("."), new Button("←") }
        };
private static final  Button[][] FUN={{ new Button( "Inv") ,new Button( "C")},
            { new Button("sinh"), new Button("sin") },
            { new Button("cosh") , new Button("cos") },
            { new Button("tanh"),new Button("tan")},
            { new Button("log"),new Button("log2")},

        };
private static final  Button[] Operation={new Button("x^2"),new Button("^"),
new Button("mod") , new Button("n!")};


    @Override
public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        //create Borderpane with background image
BorderPane pane =  new  BorderPane();
pane.setPadding(new  Insets( 10, 10,10, 10));
pane .setStyle("-fx-background-image: url('1.jpg')");
       ////Create textfield
output.setPrefHeight(70);
output. setAlignment(Pos.TOP_LEFT);
output.setStyle("-fx-font: bold italic 15pt Arial;");
       //Borderpane nodes
pane.setTop(output);
pane.setCenter( CreatNum ());
pane.setLeft(CreatFUN());
pane.setRight(CreatOP());
pane.setBottom(CreateOperation());
Event();

      /// create scene
Scene scene = new  Scene(pane,360,300); 
primaryStage.setTitle("ShowHBoxVBox"); // Set the stage title
primaryStage.setScene(scene);  // Place the scene in the stage
primaryStage.setResizable(false);
primaryStage.show(); // Display the stage


    }
    ///create Right gridpane
private GridPane CreatOP ()
    {

return ButtonDetails(operation);
    }
private GridPane CreatNum ()
    {
GridPane centerpane =new GridPane();
centerpane.setPadding(new  Insets( 10, 0,0, 15));
centerpane.setVgap(5);
centerpane.setHgap(5);
for (int i=0;i<3;i++)
        {
for (int j=0;j<4;j++)
            {
numbers[j][i].setStyle("-fx-base: mistyrose;");
numbers[j][i].setPrefSize(40, 40);
numbers[j][i].setShape(new Circle(25));
numbers[j][i].setStyle( "-fx-font: bold italic 12pt Arial;"
		+ "-fx-background-color: transparent;-fx-border-color: white;"
		+ "-fx-text-fill: white;");
centerpane.add( (numbers[j][i]), i, j);    
            }

        }
return centerpane;
    }
    ///////
private GridPane CreatFUN ()
    {

return ButtonDetails(FUN);
    }
private HBox CreateOperation()
    {
	HBox bottompane =new HBox(7);
	bottompane.setPadding(new  Insets(7, 0,0, 0));
	
for (int i=0;i<4;i++)
         {

	Operation[i].setStyle("-fx-base: mistyrose;");
	Operation[i].setPrefSize(50, 35);
	Operation[i].setShape(new Circle(20));
	Operation[i].setStyle( "-fx-font: bold italic 9pt Arial;"
		+ "-fx-background-color: transparent;-fx-border-color: white;"
		+ "-fx-text-fill: white;");
bottompane.getChildren().add( (Operation[i])); 
bottompane.setAlignment(Pos.CENTER);

         }
	
		return bottompane;
	
    }
private GridPane ButtonDetails(Button[][] Buttons){
	GridPane pane =new GridPane();
pane.setPadding(new  Insets(10, 0,0, 0));
pane.setVgap(5);
pane.setHgap(5);
for (int i=0;i<2;i++)
         {
for (int j=0;j<4;j++)
             {
	Buttons[j][i].setStyle("-fx-base: mistyrose;");
	Buttons[j][i].setPrefSize(45, 40);
	Buttons[j][i].setShape(new Circle(20));
	Buttons[j][i].setStyle( "-fx-font: bold italic 8pt Arial;"
		+ "-fx-background-color: transparent;-fx-border-color: white;"
		+ "-fx-text-fill: white;");
pane.add( (Buttons[j][i]), i, j); 
             }
         }
		return pane;
	
	
    }
private void Event()
    {
for (int i=0;i<2;i++)
    {
for (int j=0;j<4;j++)
        {
try
            {

putonaction (FUN[j][i]);
putonaction (operation[j][i]);

            }       
catch(Exception e)
            {

            }
        }

        }
for(int i=0;i<4;i++)
    {
	putonaction(Operation[i]);
    }

for (int i=0;i<3;i++)
    {
for (int j=0;j<4;j++)
        {
putonaction (numbers[j][i]);
        }
        }


    }
private void putonaction (Button b)
    {

b.setOnAction(e ->  {

String s = b.getText();



String text  =outtext(s);

output.setText(text); 

        }


        );
        }

           
         private String outtext(String s)
            {  
             String st = "";

             if(s=="C")
             {   
                eq.clear();
                 s="";
                 return s;
                 }
             else
                 if(s=="?")
                 {
                     try
                     {
                     eq.remove(eq.size()-1);
                     for(int i=0;i<eq.size();i++)
                         st+=eq.get(i);
                     }
                     catch(Exception ex)
                     {}
                      return st;
                     
                 }
                 else if(s=="=")
                 {       
                     for(int i=0;i<eq.size();i++)
                         st+=eq.get(i);
                	 String r=  performequation(st);
                	   return r;
                 }
                 else
                 {
            eq.add(s);
          for(int i=0;i<eq.size();i++)
             st+=eq.get(i);
          return st;
                 }
            }
         private String performequation(String s)
         {
             //////////////////////char array////////////////////////////////////////////////
           char[] charArray = s.toCharArray();
        
           ///////////////////////ZahraComment//////////////////////////
          //for (int i=0;i<charArray.length;i++)
           //{
               if (charArray[0]=='+'|charArray[0]=='-'|charArray[0]=='*'
            		   |charArray[0]=='%'|charArray[0]=='/'|charArray[0]=='^'){
            	
            	   
            	   
             //  {
            	   ////////////////////Zahra//////////////////////////////
            	//   
                   s="";
           return s;
           }
               
           else
           {
               String nn1 = "";
               String nn2 = "";
               //String res = "";
               String ch = "";
               
               
               for(int j = 0;j<charArray.length;j++){
               if(Character.isDigit(charArray[j])|charArray[j]=='.'&& ch == ""){
            	   nn1 += charArray[j];
               }
               
               
               else if (!Character.isDigit(charArray[j])&&nn2 == "")
            		   {
                	   ch += charArray[j];
            		   }

               
               
               else 
            	 //  if(Character.isDigit(charArray[i])&& ch !=' '){
                      
                   	   nn2 += charArray[j];
              // }
               //else{
               }
               switch (ch) {
			case "+":
				s = String.valueOf(Double.parseDouble(nn1) + Double.parseDouble(nn2));
				//return s;	
				break;
			case "-":
				s = String.valueOf(Double.parseDouble(nn1) - Double.parseDouble(nn2));
				//return res;
			
			case "*":
				s = String.valueOf(Double.parseDouble(nn1) * Double.parseDouble(nn2));
				break;
			case"^":
				 s = String.valueOf(Math.pow(Double.parseDouble(nn1), Integer.parseInt(nn2)));
				  break;
			case"√":
				s= String.valueOf(Math.sqrt(Double.parseDouble(nn2)));
				break;
			case"log":
				s=String.valueOf(Math.log(Double.parseDouble(nn2)));
				break;
			case"log10":
				s=String.valueOf(Math.log10(Double.parseDouble(nn2)));
				break;
			case"exp":	
			s= String.valueOf(Math.exp(Double.parseDouble(nn1)));
			break;
			case"cube√":
			s=String.valueOf(Math.cbrt(Double.parseDouble(nn2)));
			break;
			case"sinh": 
				s=String.valueOf(Math.sinh(Double.parseDouble(nn2)));
				break;
			case"cosh": 
				s=String.valueOf(Math.cosh(Double.parseDouble(nn2)));
				break;
			case"tanh": 
				s=String.valueOf(Math.tanh(Double.parseDouble(nn2)));
				break;
			case"n!":
				 int  c, fact = 1;
				 for ( c = 1 ; c <=(Double.parseDouble(nn2)) ; c++ )
			            fact = fact*c;
				 s=String.valueOf(fact);
			break; 
			case"sin": 
				s=String.valueOf(Math.sin(Double.parseDouble(nn2)));
				break;
			case"cos": 
				s=String.valueOf(Math.cos(Double.parseDouble(nn2)));
				break;
			case"tan": 
				s=String.valueOf(Math.tan(Double.parseDouble(nn2)));
				break;
			
			case"mod":
				s = String.valueOf(Double.parseDouble(nn1) % Double.parseDouble(nn2));
				break;
			case"Inv":
				try{
				double y =0;
				y = (1 / (Double.parseDouble(nn2)));
				s= String.valueOf(y);}
				catch(ArithmeticException ex) {
					
					s = "cannot be divided by zero ";
				}
				break;
				
			case "/":
			{
				try{
				s = String.valueOf(Double.parseDouble(nn1) / Double.parseDouble(nn2));
					}catch(ArithmeticException ex) {
			
				s = "cannot be divided by zero ";
			}
			}
			break;
			default:
            	s = "unvalid operation";	
            	}
               }
              // eq.clear();    
          return s;
          
           }
    public static void  main(String[] args) { 
        Application.launch(args); 
      }
}