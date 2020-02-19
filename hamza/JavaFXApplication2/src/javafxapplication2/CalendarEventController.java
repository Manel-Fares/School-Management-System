/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import com.gembox.spreadsheet.ExcelFile;
import com.gembox.spreadsheet.ExcelWorksheet;
import com.gembox.spreadsheet.SpreadsheetInfo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXColorPicker;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.effects.JFXDepthManager;
import entity.CalendarAnnuel;
import entity.Emplois;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.print.PrinterJob;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import service.CalendarAnnuelService;

/**
 * FXML Controller class
 *
 * @author Baklouti
 */
public class CalendarEventController implements Initializable {
    
     static {
        SpreadsheetInfo.setLicense("FREE-LIMITED-KEY");
    }

    @FXML
    private GridPane calendarGrid;
    @FXML
    private HBox weekdayHeader;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private JFXListView<String> monthSelect;
    @FXML
    private Label monthLabel;
    @FXML
    private JFXComboBox<String> selectedYear;
    @FXML
    private AnchorPane rootPane;
    
    public int viewing_month;
    public int viewing_year;
    @FXML
    private VBox centerArea;
    @FXML
    private Label calendarNameLbl;
    int k=0,j=0;
    @FXML
    private JFXButton pdf;
    @FXML
    private JFXButton excel;
    AddEventController mainController;
    
     public void setMainController(AddEventController mainController) {
        this.mainController = mainController ;
    }
     public VBox getVBox()
     {
         return this.centerArea;
     }
     
    public int getMonthIndex(String month) {
        switch (month) {
            case "janvier":
                return 0;
            case "février":
                return 1;
            case "mars":
                return 2;
            case "avril":
                return 3;
            case "mai":
                return 4;
            case "juin":
                return 5;
            case "juillet":
                return 6;
            case "août":
                return 7;
            case "septembre":
                return 8;
            case "octobre":
                return 9;
            case "novembre":
                return 10;
            case "décembre":
                return 11;
        }
        return 0;
    }
    
    
     private void addEvent(VBox day) {
        
        // Purpose - Add event to a day
        
        // Do not add events to days without labels
        if(!day.getChildren().isEmpty()) {
            
            // Get the day number
            Label lbl = (Label) day.getChildren().get(0);
            System.out.println(lbl.getText());
            
            // Store event day and month in data singleton
            System.out.println(lbl.getText());
            String month =String.valueOf( Model.getInstance().getMonthIndex(monthSelect.getSelectionModel().getSelectedItem())+1);      
            String year=selectedYear.getValue();
            
            // Open add event view
            try {
               // Load root layout from fxml file.
               FXMLLoader loader = new FXMLLoader();
               loader.setLocation(getClass().getResource("add_event.fxml"));
               AnchorPane rootLayout = (AnchorPane) loader.load();
               Stage stage = new Stage(StageStyle.UNDECORATED);
               stage.initModality(Modality.APPLICATION_MODAL); 

               // Pass main controller reference to view
               AddEventController eventController = loader.getController();
               eventController.setMainController(this);
               eventController.setData(lbl.getText(), month, year);
               // Show the scene containing the root layout.
               
               Scene scene = new Scene(rootLayout);
               
               stage.setScene(scene);
               stage.show();
           } catch (IOException ex) {
               Logger.getLogger(CalendarEventController.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
    }  
     
 
    

    public void initializeCalendarGrid() {
        
     
        // Go through each calendar grid location, or each "day" (7x6)
        int rows = 6;
        int cols = 7;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                // Add VBox and style it
                VBox vPane = new VBox();
                vPane.getStyleClass().add("calendar_pane");
                vPane.setMinWidth(weekdayHeader.getPrefWidth() / 7);

                 vPane.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->{
                    addEvent(vPane);
                 
                });
                 System.out.println("here33333");
               
                GridPane.setVgrow(vPane, Priority.ALWAYS);

                // Add it to the grid
                calendarGrid.add(vPane, j, i);
            }
        }

         
        // Set up Row Constraints
        for (int i = 0; i < 7; i++) {
            RowConstraints row = new RowConstraints();
            row.setMinHeight(scrollPane.getHeight() / 7);
            calendarGrid.getRowConstraints().add(row);
        }
     
        
    }

    public void initializeCalendarWeekdayHeader() {

        // 7 days in a week
        int weekdays = 7;

        // Weekday names
        String[] weekAbbr = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

        for (int i = 0; i < weekdays; i++) {

            // Make new pane and label of weekday
            StackPane pane = new StackPane();
            pane.getStyleClass().add("weekday-header");

            // Make panes take up equal space
            HBox.setHgrow(pane, Priority.ALWAYS);
            pane.setMaxWidth(Double.MAX_VALUE);

            // Note: After adding a label to this, it tries to resize itself..
            // So I'm setting a minimum width.
            pane.setMinWidth(weekdayHeader.getPrefWidth() / 7);

            // Add it to the header
            weekdayHeader.getChildren().add(pane);

            // Add weekday name
            pane.getChildren().add(new Label(weekAbbr[i]));
        }
    }

    private void loadCalendarLabels() {
        // Get the current VIEW
        int year = viewing_year;
        int month = viewing_month;

        // Note: Java's Gregorian Calendar class gives us the right
        // "first day of the month" for a given calendar & month
        // This accounts for Leap Year
        GregorianCalendar gc = new GregorianCalendar(year, month, 1);
        int firstDay = gc.get(Calendar.DAY_OF_WEEK);
        int daysInMonth = gc.getActualMaximum(Calendar.DAY_OF_MONTH);

        // We are "offsetting" our start depending on what the
        // first day of the month is.
        // For example: Sunday start, Monday start, Wednesday start.. etc
        int offset = firstDay;
        int gridCount = 1;
        int lblCount = 1;

        // Go through calendar grid
        for (Node node : calendarGrid.getChildren()) {

            VBox day = (VBox) node;

            day.getChildren().clear();
            day.setStyle("-fx-backgroud-color: white");
            day.setStyle("-fx-font: 14px \"System\" ");

            // Start placing labels on the first day for the month
            if (gridCount < offset) {
                gridCount++;
                // Darken color of the offset days
                day.setStyle("-fx-background-color: #E9F2F5");
            } else {

                // Don't place a label if we've reached maximum label for the month
                if (lblCount > daysInMonth) {
                    // Instead, darken day color
                    day.setStyle("-fx-background-color: #E9F2F5");
                } else {

                    // Make a new day label   
                    Label lbl = new Label(Integer.toString(lblCount));
                    lbl.setPadding(new Insets(5));
                    lbl.setStyle("-fx-text-fill:darkslategray");

                    day.getChildren().add(lbl);
                }

                lblCount++;
            }
        }
    }

      public int GetDay() {
        int currentNumber=0  ;
        for (Node node : calendarGrid.getChildren()) {

            // Get the current day    
            VBox day = (VBox) node;

            // Don't look at any empty days (they at least must have a day label!)
            if (!day.getChildren().isEmpty()) {

                // Get the day label for that day
                Label lbl = (Label) day.getChildren().get(0);

                // Get the number
                currentNumber = Integer.parseInt(lbl.getText());
                System.out.println(currentNumber);

                // Did we find a match?
            
            }
        }
        return  currentNumber;
    }

     public void showDate(int dayNumber, String descript) {

        for (Node node : calendarGrid.getChildren()) {

            // Get the current day    
            VBox day = (VBox) node;

            // Don't look at any empty days (they at least must have a day label!)
            if (!day.getChildren().isEmpty()) {

                // Get the day label for that day
                Label lbl = (Label) day.getChildren().get(0);

                // Get the number
                int currentNumber = Integer.parseInt(lbl.getText());
                System.out.println(currentNumber);

                // Did we find a match?
                if (currentNumber == dayNumber) {

                    // Add an event label with the given description
                    Label eventLbl = new Label(descript);

                    eventLbl.getStyleClass().add("event-label");

                    eventLbl.setStyle("-fx-background-color: #d8d3f5");

                    // Stretch to fill box
                    eventLbl.setMaxWidth(Double.MAX_VALUE);

                    // Mouse effects
                    eventLbl.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> {
                        eventLbl.getScene().setCursor(Cursor.HAND);
                    });

                    eventLbl.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> {
                        eventLbl.getScene().setCursor(Cursor.DEFAULT);
                    });

                    // Add label to calendar
                    day.getChildren().add(eventLbl);
                }
            }
        }
    }

    
    
    private void populateMonthWithEvents() {

        // Get viewing calendar
        //String calendarName = Model.getInstance().calendar_name;
        String currentMonth = monthLabel.getText();

        int currentMonthIndex = getMonthIndex(currentMonth) + 1;
        int currentYear = Integer.parseInt(selectedYear.getValue());

        //List<Evenement> events = new EvenementDao().displayAll();
        
        
        ArrayList<Emplois> events = new ArrayList<>();

       
        
        for (Emplois e : events) {

            // Get date for the event
            LocalDate eventDate = e.getDate().toLocalDate();
            String eventDescript = e.getSource();

            // Check for year we have selected
            if (currentYear == eventDate.getYear()) {
                // Check for the month we already have selected (we are viewing)
                if (currentMonthIndex == eventDate.getMonthValue()) {

                    // Get day for the month
                    int day = eventDate.getDayOfMonth();

                    // Display decription of the event given it's day
                    showDate(day, eventDescript);
               
                }
            }

        }

    }

    public void repaintView() {
        // Purpose - To be usable anywhere to update view
        // 1. Correct calendar labels based on Gregorian Calendar 
        // 2. Display events known to database

        loadCalendarLabels();
        populateMonthWithEvents();
        
        

    }

    private void initializeMonthSelector() {
        

        // Add event listener to each month list item, allowing user to change months
        monthSelect.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                // Necessary to check for null because change listener will
                // also detect clear() calls
                if (newValue != null) {

                    // Show selected/current month above calendar
                    monthLabel.setText(newValue);

                    // Update the VIEWING MONTH
                    viewing_month = getMonthIndex(newValue);

                    // Update view
                    repaintView();
                }

            }
        });

        // Add event listener to each year item, allowing user to change years
        selectedYear.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                if (newValue != null) {

                    // Update the VIEWING YEAR
                    viewing_year = Integer.parseInt(newValue);

                    // Update view
                    repaintView();
                   
                }
            }
        });
        
        
    }

    public void calendarGenerate() {
        // Load year selection
        selectedYear.getItems().clear(); // Note: Invokes its change listener
        selectedYear.getItems().add(Integer.toString(2019));
        selectedYear.getItems().add(Integer.toString(2020));

        // Select the first YEAR as default     
        selectedYear.getSelectionModel().selectFirst();

        // Update the VIEWING YEAR
        viewing_year = Integer.parseInt(selectedYear.getSelectionModel().getSelectedItem());

        // Enable year selection box
        selectedYear.setVisible(true);

        // Set calendar name label
        //calendarNameLbl.setText(Model.getInstance().calendar_name);
        // Get a list of all the months (1-12) in a year
        DateFormatSymbols dateFormat = new DateFormatSymbols();
        String months[] = dateFormat.getMonths();
        String[] spliceMonths = Arrays.copyOfRange(months, 0, 12);

        // Load month selection
        monthSelect.getItems().clear();
        monthSelect.getItems().addAll(spliceMonths);

        // Select the first MONTH as default
        monthSelect.getSelectionModel().selectFirst();
        monthLabel.setText(monthSelect.getSelectionModel().getSelectedItem());

        // Update the VIEWING MONTH
        viewing_month = getMonthIndex(monthSelect.getSelectionModel().getSelectedItem());

        // Update view
        repaintView();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      //  rootPane.getChildren().add(new MenuComponentEventController());
        rootPane.autosize();
        rootPane.getHeight();
        System.out.println("");
        initializeCalendarGrid();
        initializeCalendarWeekdayHeader();
        initializeMonthSelector();
        JFXDepthManager.setDepth(scrollPane, 1);
        calendarGenerate();
        repaintView();
     /*    for (int i = 0 ; i < 7 ; i++) {
            for (int j = 0; j < 6; j++) {
                
                addPane(i, j);
                
            }}*/
 
    }
    
    
     private void addPane(int colIndex, int rowIndex) {
         VBox day = new VBox();
        day.setOnMouseClicked((MouseEvent e) -> {
            System.out.printf("Mouse enetered cell [%d, %d]%n", colIndex, rowIndex);
            
            day.setStyle("-fx-background-color:rgba(255,0,0,0.7);");
             System.out.println(getMonthIndex(monthSelect.getSelectionModel().getSelectedItem())+1);
             System.out.println(selectedYear.getSelectionModel().getSelectedItem());
             //System.out.println(getNodeByRowColumnIndex(rowIndex,colIndex,calendarGrid));
           /* GregorianCalendar gc = new GregorianCalendar(Integer.parseInt(selectedYear.getSelectionModel().getSelectedItem()), getMonthIndex(monthSelect.getSelectionModel().getSelectedItem())+1, 1);
        int firstDay = gc.get(Calendar.DAY_OF_WEEK);
        int daysInMonth = gc.getActualMaximum(Calendar.DAY_OF_MONTH);
            System.out.println(firstDay);
            System.out.println(daysInMonth);*/
           
           JFXButton b = new JFXButton("Unavaible");
 
            System.out.println(GetDay());

           day.getChildren().add(b);
   
        });
        
        calendarGrid.add(day, colIndex, rowIndex);
    }
     
         public void exportCalendarPDF()
    {
         TableView<CalendarAnnuel> table = new TableView<>();
         ObservableList<CalendarAnnuel> data =FXCollections.observableArrayList();  
   
        
        double w = 500.00;
        // set width of table view
        table.setPrefWidth(w);
        // set resize policy
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        // intialize columns
        TableColumn<CalendarAnnuel,String> term  = new TableColumn<>("Subject");
        TableColumn<CalendarAnnuel,String> subject  = new TableColumn<>("Term");
        TableColumn<CalendarAnnuel,String> date = new TableColumn<>("DateC");
        // set width of columns
        term.setMaxWidth( 1f * Integer.MAX_VALUE * 20 ); // 50% width
        subject.setMaxWidth( 1f * Integer.MAX_VALUE * 20 ); // 50% width
        date.setMaxWidth( 1f * Integer.MAX_VALUE * 20 ); // 50% width
        // 
        term.setCellValueFactory(new PropertyValueFactory<>("subject"));
        subject.setCellValueFactory( new PropertyValueFactory<>("term"));
        date.setCellValueFactory(new PropertyValueFactory<>("datec"));
        
        // Add columns to the table
        table.getColumns().add(term);
        table.getColumns().add(subject);
        table.getColumns().add(date);
 
         CalendarAnnuelService cas=new CalendarAnnuelService();
         data=cas.GetCalendar();       
        table.getItems().setAll(data);
        // open dialog window and export table as pdf
        PrinterJob job = PrinterJob.createPrinterJob();
        if(job != null){
          job.printPage(table);
          job.endJob();
        }
       }
    
     
    public void exportCalendarExcel() throws IOException{

                 TableView<CalendarAnnuel> table = new TableView<CalendarAnnuel>();
         ObservableList<CalendarAnnuel> data =FXCollections.observableArrayList();  
         ObservableList<CalendarAnnuel> data2 =FXCollections.observableArrayList();  
           CalendarAnnuelService cas=new CalendarAnnuelService();
         data=cas.GetCalendar();       
        table.getItems().setAll(data);
          ExcelFile file = new ExcelFile();
        ExcelWorksheet worksheet = file.addWorksheet("sheet");
        for (int row = 0; row < table.getItems().size(); row++) {
            data2.add(table.getItems().get(row));
            ObservableList<CalendarAnnuel> cells =  data2;
            for (int column = 0; column < cells.size(); column++) {
                if (cells.get(column) != null)
                    worksheet.getCell(row, column).setValue(cells.get(column).toString());
            }
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("XLSX files (*.xlsx)", "*.xlsx"),
                new FileChooser.ExtensionFilter("XLS files (*.xls)", "*.xls"),
                new FileChooser.ExtensionFilter("ODS files (*.ods)", "*.ods"),
                new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv"),
                new FileChooser.ExtensionFilter("HTML files (*.html)", "*.html")
        );
        File saveFile = fileChooser.showSaveDialog(calendarGrid.getScene().getWindow());

        file.save(saveFile.getAbsolutePath());

    }
    @FXML
    private void pdfAction(ActionEvent event) {
         exportCalendarPDF();
    }

    @FXML
    private void excelAction(ActionEvent event) throws IOException {
       exportCalendarExcel();
        
    }

}
