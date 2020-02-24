/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import com.gembox.spreadsheet.ExcelColumn;
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
import javafx.event.EventHandler;
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
/*import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;*/
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.table.DefaultTableModel;
//import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

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
    CalendarEventController cal;
    boolean Check=false;
    @FXML
    private JFXButton Reload;
    DefaultTableModel dm = new DefaultTableModel();
    
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
        CalendarAnnuelService cas = new CalendarAnnuelService();
        if(!day.getChildren().isEmpty()) {
            Label lbl = (Label) day.getChildren().get(0);
            System.out.println(lbl.getText());
            String month =String.valueOf(getMonthIndex(monthSelect.getSelectionModel().getSelectedItem())+1);      
            String year=selectedYear.getValue();
         //   System.out.println(lbl.getText());
            for (CalendarAnnuel a :cas.GetDateCalendar() )
                    {
                        LocalDate ld = a.getDateC().toLocalDate();

                    if((ld.getDayOfMonth()==Integer.valueOf(lbl.getText())) && (ld.getMonthValue()==Integer.valueOf(month)) && (ld.getYear()==Integer.valueOf(year)))
                    {
                        Check=true;
                    }                    
                    }
            
            // Get the day number
            
            
            // Store event day and month in data singleton
            
            if(!Check)
            {
            // Open add event view
            try {
               // Load root layout from fxml file.
               FXMLLoader loader = new FXMLLoader();
               loader.setLocation(getClass().getResource("add_event.fxml"));
               AnchorPane rootLayout = (AnchorPane) loader.load();
               Stage stage = new Stage(StageStyle.UNDECORATED);
               stage.initModality(Modality.APPLICATION_MODAL); 
              /* day.setStyle("-fx-background-color:rgba(255,0,0,0.7);");       
               JFXButton b = new JFXButton("Unavaible");
               day.getChildren().add(b);*/
               // Pass main controller reference to view
               AddEventController eventController = loader.getController();
               eventController.setMainController(this);
               eventController.setData(lbl.getText(), month, year);
               // Show the scene containing the root layout.
               
               Scene scene = new Scene(rootLayout);
               
               stage.setScene(scene);
               stage.show();
               
           } catch (IOException ex) {
               //Logger.getLogger(CalendarEventController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("error");
           }
            
        }}
        Check=false;
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
                // System.out.println("here33333");
               
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

    public void loadCalendarLabels() {

        int year = viewing_year;
        int month = viewing_month;

        GregorianCalendar gc = new GregorianCalendar(year, month, 1);
        int firstDay = gc.get(Calendar.DAY_OF_WEEK);
        int daysInMonth = gc.getActualMaximum(Calendar.DAY_OF_MONTH);

        int offset = firstDay;
        int gridCount = 1;
        int lblCount = 1;

        for (Node node : calendarGrid.getChildren()) {

            VBox day = (VBox) node;

            day.getChildren().clear();
            day.setStyle("-fx-backgroud-color: white");
            day.setStyle("-fx-font: 14px \"System\" ");

            if (gridCount < offset) {
                gridCount++;

                day.setStyle("-fx-background-color: #E9F2F5");
            } else {

                if (lblCount > daysInMonth) {

                    day.setStyle("-fx-background-color: #E9F2F5");
                } else {
                    
                     Label lbl = new Label(Integer.toString(lblCount));
                     lbl.setPadding(new Insets(5));
                    lbl.setStyle("-fx-text-fill:darkslategray");
                    day.getChildren().add(lbl);
                    //String months =String.valueOf( Model.getInstance().getMonthIndex(monthSelect.getSelectionModel().getSelectedItem())+1);      
                    //String years=selectedYear.getValue();
                    //Date q = new Date(Integer.valueOf(years), Integer.valueOf(months), Integer.valueOf(lbl.getText()));
                    CalendarAnnuelService cas = new CalendarAnnuelService();
                   // CalendarAnnuel ca =cas.GetDateCalendar();
                   // System.out.println(ca);
                  //  System.out.println("qq"+lblCount);
                   // System.out.println(ca.getDateC().getDate());

                    for (CalendarAnnuel a :cas.GetDateCalendar() )
                    {

                        LocalDate ld = a.getDateC().toLocalDate();

                    if((ld.getDayOfMonth()==lblCount) && (ld.getMonthValue()==month+1) && (ld.getYear()==year))
                    {
                       // System.out.println("qqqq");
                    //day.setStyle("-fx-background-color:rgba(255,0,0,0.7);");       
                    JFXButton b = new JFXButton(a.getSubject());
                    JFXButton b1 = new JFXButton(a.getTerm());
                    b.setStyle("    -fx-font: 13px \"System\";\n" +
                               "    -fx-background-color: white;\n" +
                               "    -fx-border-width:1.5;\n" +
                               "    -fx-padding: 2px;\n" +
                               "    -fx-border-radius: 4px;\n" +
                               "    -fx-background-radius: 4px;\n" +
                               "    -fx-border-color: #333;\n" +
                               "    -fx-padding: 2px;\n" +
                               "    -fx-text-fill: black;\n" +
                               "    -fx-background-insets: 2px;");
                    day.getChildren().add(b);   
                    //day.getChildren().add(b1); 
                    b.setOnAction(new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            try {
                                
                                FXMLLoader loader = new FXMLLoader();
                                loader.setLocation(getClass().getResource("UpdateDeleteCalendar.fxml"));
                                AnchorPane rootLayout = (AnchorPane) loader.load();
                                Stage stage = new Stage(StageStyle.UNDECORATED);
                                stage.initModality(Modality.APPLICATION_MODAL);
                                UpdateDeleteCalendarController eventController = loader.getController();
                                eventController.setMainController(cal);
                                eventController.setData(String.valueOf(a.getId()),a.getSubject(),a.getTerm(),ld);
                                Scene scene = new Scene(rootLayout);                              
                                stage.setScene(scene);
                                stage.show();} catch (IOException ex) {
                                Logger.getLogger(CalendarEventController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });
                    } 
                    }
                      
                    
                    
                }

                lblCount++;
            }
        }
    }

      public int GetDay() {
        int currentNumber=0  ;
        for (Node node : calendarGrid.getChildren()) {

           
            VBox day = (VBox) node;

          
            if (!day.getChildren().isEmpty()) {

                
                Label lbl = (Label) day.getChildren().get(0);

               
                currentNumber = Integer.parseInt(lbl.getText());
                System.out.println(currentNumber);

              
            
            }
        }
        return  currentNumber;
    }

  /*   public void showDate(int dayNumber, String descript) {

        for (Node node : calendarGrid.getChildren()) {

         
            VBox day = (VBox) node;

          
            if (!day.getChildren().isEmpty()) {

       
                Label lbl = (Label) day.getChildren().get(0);

               
                int currentNumber = Integer.parseInt(lbl.getText());
                System.out.println(currentNumber);

           
                if (currentNumber == dayNumber) {

                
                    Label eventLbl = new Label(descript);

                    eventLbl.setStyle("-fx-background-color: #d8d3f5");

                 
                    eventLbl.setMaxWidth(Double.MAX_VALUE);

                  
                    eventLbl.addEventHandler(MouseEvent.MOUSE_ENTERED, (e) -> {
                        eventLbl.getScene().setCursor(Cursor.HAND);
                    });

                    eventLbl.addEventHandler(MouseEvent.MOUSE_EXITED, (e) -> {
                        eventLbl.getScene().setCursor(Cursor.DEFAULT);
                    });

               
                    day.getChildren().add(eventLbl);
                }
            }
        }
    }

    */
    
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
//                    showDate(day, eventDescript);
               
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
        selectedYear.getItems().add(Integer.toString(2011));
        selectedYear.getItems().add(Integer.toString(2012));
        selectedYear.getItems().add(Integer.toString(2013));
        selectedYear.getItems().add(Integer.toString(2014));
        selectedYear.getItems().add(Integer.toString(2015));
        selectedYear.getItems().add(Integer.toString(2016));
        selectedYear.getItems().add(Integer.toString(2017));
        selectedYear.getItems().add(Integer.toString(2018));
        selectedYear.getItems().add(Integer.toString(2019));
        selectedYear.getItems().add(Integer.toString(2020));
        selectedYear.getItems().add(Integer.toString(2021));
        selectedYear.getItems().add(Integer.toString(2022));
        selectedYear.getItems().add(Integer.toString(2023));

        // Select the first YEAR as default     
        selectedYear.getSelectionModel().select(9);

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
       /*  for (int i = 0 ; i < 7 ; i++) {
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

           
           JFXButton b = new JFXButton("Unavaible");
 
            System.out.println(GetDay());

           day.getChildren().add(b);
   
        });
        
        calendarGrid.add(day, colIndex, rowIndex);
    }
     /*
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
    */
         private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }
    public void exportCalendarExcel() throws IOException{
        ObservableList<CalendarAnnuel> data =FXCollections.observableArrayList();          
        CalendarAnnuelService cas=new CalendarAnnuelService();
        data=cas.GetCalendar();       
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Employees sheet");
        int rownum = 0;
        Cell cell;
        Row row;
        //
        HSSFCellStyle style = createStyleForTitle(workbook);
 
        row = sheet.createRow(rownum);
 
        // Subject
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Subject");
        cell.setCellStyle(style);
        // Term
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Term");
        cell.setCellStyle(style);
        // Date
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Date");
        cell.setCellStyle(style);

 
        // Data
        for (CalendarAnnuel ca : data) {
            rownum++;
            row = sheet.createRow(rownum);
 
            // 
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(ca.getSubject());
            // 
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(ca.getTerm());
            // 
            cell = row.createCell(2, CellType.NUMERIC);
            cell.setCellValue(ca.getDateC().toString());

        }
         FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("XLS files (*.xls)", "*.xls"),
                new FileChooser.ExtensionFilter("ODS files (*.ods)", "*.ods"),
                new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv"),
                new FileChooser.ExtensionFilter("HTML files (*.html)", "*.html")
        );
                File file = new File(fc.showSaveDialog(null).getAbsolutePath());
        file.getParentFile().mkdirs();
 
        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
        System.out.println("Created file: " + file.getAbsolutePath());
    }
 
    
    public void exportCalendarPDF() throws FileNotFoundException,DocumentException {
        
 //FileNotFoundException, DocumentException 
              Document doc = new Document();
FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PDF files (.pdf)", ".pdf"),
                new FileChooser.ExtensionFilter("HTML files (.html)", ".html")
        );
        File saveFile = fileChooser.showSaveDialog(calendarGrid.getScene().getWindow());

      //  file.save(saveFile.getAbsolutePath());
        
        PdfWriter.getInstance(doc,new FileOutputStream(saveFile.getAbsolutePath()));
        doc.open();
        System.out.println(doc.getHtmlStyleClass());
                 CalendarAnnuelService cas=new CalendarAnnuelService();
         for ( CalendarAnnuel p :cas.GetCalendar())
         {             
        doc.add(new Paragraph("Subject :"+p.getSubject()));
        doc.add(new Paragraph("Term  :"+p.getTerm()));
        doc.add(new Paragraph("Date  :"+p.getDateC()));
        doc.add(new Paragraph("=========================================="));
         }
        
        doc.close();
            
    }
    
    @FXML
    private void pdfAction(ActionEvent event) throws FileNotFoundException, DocumentException {
         exportCalendarPDF();
    }

    @FXML
    private void excelAction(ActionEvent event) throws IOException {
       exportCalendarExcel();
        
    }

    @FXML
    private void ReloadAction(ActionEvent event) {
        loadCalendarLabels();
    }

}
