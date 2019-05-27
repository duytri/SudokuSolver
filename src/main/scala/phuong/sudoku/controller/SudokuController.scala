package main.scala.phuong.sudoku.controller

import scalafxml.core.macros.sfxml
import javafx.fxml.FXML
import scalafx.event.ActionEvent
import com.jfoenix.controls.JFXDialog
import com.jfoenix.controls.JFXDialogLayout
import com.jfoenix.controls.JFXButton
import scalafx.application.Platform
import java.util.ArrayList
import main.scala.phuong.sudoku.main.SudokuSolver
import javafx.scene.layout.StackPane
import javafx.scene.text.Text
import scalafx.scene.input.InputMethodEvent
import scalafx.scene.control.TextField
import scalafx.beans.Observable
import javafx.beans.value.ChangeListener
import javafx.beans.value.ObservableValue
import scalafx.scene.image.ImageView
import scalafx.animation.TranslateTransition
import scalafx.util.Duration

@sfxml
class SudokuController(
  @FXML private val tf00: TextField,
  @FXML private val tf01: TextField,
  @FXML private val tf02: TextField,
  @FXML private val tf03: TextField,
  @FXML private val tf04: TextField,
  @FXML private val tf05: TextField,
  @FXML private val tf06: TextField,
  @FXML private val tf07: TextField,
  @FXML private val tf08: TextField,
  @FXML private val tf10: TextField,
  @FXML private val tf11: TextField,
  @FXML private val tf12: TextField,
  @FXML private val tf13: TextField,
  @FXML private val tf14: TextField,
  @FXML private val tf15: TextField,
  @FXML private val tf16: TextField,
  @FXML private val tf17: TextField,
  @FXML private val tf18: TextField,
  @FXML private val tf20: TextField,
  @FXML private val tf21: TextField,
  @FXML private val tf22: TextField,
  @FXML private val tf23: TextField,
  @FXML private val tf24: TextField,
  @FXML private val tf25: TextField,
  @FXML private val tf26: TextField,
  @FXML private val tf27: TextField,
  @FXML private val tf28: TextField,
  @FXML private val tf30: TextField,
  @FXML private val tf31: TextField,
  @FXML private val tf32: TextField,
  @FXML private val tf33: TextField,
  @FXML private val tf34: TextField,
  @FXML private val tf35: TextField,
  @FXML private val tf36: TextField,
  @FXML private val tf37: TextField,
  @FXML private val tf38: TextField,
  @FXML private val tf40: TextField,
  @FXML private val tf41: TextField,
  @FXML private val tf42: TextField,
  @FXML private val tf43: TextField,
  @FXML private val tf44: TextField,
  @FXML private val tf45: TextField,
  @FXML private val tf46: TextField,
  @FXML private val tf47: TextField,
  @FXML private val tf48: TextField,
  @FXML private val tf50: TextField,
  @FXML private val tf51: TextField,
  @FXML private val tf52: TextField,
  @FXML private val tf53: TextField,
  @FXML private val tf54: TextField,
  @FXML private val tf55: TextField,
  @FXML private val tf56: TextField,
  @FXML private val tf57: TextField,
  @FXML private val tf58: TextField,
  @FXML private val tf60: TextField,
  @FXML private val tf61: TextField,
  @FXML private val tf62: TextField,
  @FXML private val tf63: TextField,
  @FXML private val tf64: TextField,
  @FXML private val tf65: TextField,
  @FXML private val tf66: TextField,
  @FXML private val tf67: TextField,
  @FXML private val tf68: TextField,
  @FXML private val tf70: TextField,
  @FXML private val tf71: TextField,
  @FXML private val tf72: TextField,
  @FXML private val tf73: TextField,
  @FXML private val tf74: TextField,
  @FXML private val tf75: TextField,
  @FXML private val tf76: TextField,
  @FXML private val tf77: TextField,
  @FXML private val tf78: TextField,
  @FXML private val tf80: TextField,
  @FXML private val tf81: TextField,
  @FXML private val tf82: TextField,
  @FXML private val tf83: TextField,
  @FXML private val tf84: TextField,
  @FXML private val tf85: TextField,
  @FXML private val tf86: TextField,
  @FXML private val tf87: TextField,
  @FXML private val tf88: TextField,
  @FXML private val btnStart: JFXButton,
  @FXML private val btnStop: JFXButton,
  @FXML private val btnDelete: JFXButton,
  @FXML private val imgSally: ImageView) {
  
  // Sally animation
  val tt = new TranslateTransition
  tt.setDuration(Duration(1000))
  tt.setAutoReverse(true)
  tt.setCycleCount(1000)
  tt.setToY(-23)
  tt.setNode(imgSally)
  tt.play
  

  val arrayTF = Array(
    Array(tf00, tf01, tf02, tf10, tf11, tf12, tf20, tf21, tf22),
    Array(tf03, tf04, tf05, tf13, tf14, tf15, tf23, tf24, tf25),
    Array(tf06, tf07, tf08, tf16, tf17, tf18, tf26, tf27, tf28),

    Array(tf30, tf31, tf32, tf40, tf41, tf42, tf50, tf51, tf52),
    Array(tf33, tf34, tf35, tf43, tf44, tf45, tf53, tf54, tf55),
    Array(tf36, tf37, tf38, tf46, tf47, tf48, tf56, tf57, tf58),

    Array(tf60, tf61, tf62, tf70, tf71, tf72, tf80, tf81, tf82),
    Array(tf63, tf64, tf65, tf73, tf74, tf75, tf83, tf84, tf85),
    Array(tf66, tf67, tf68, tf76, tf77, tf78, tf86, tf87, tf88))

    // Add Text Field validation
  arrayTF.foreach(row => {
    row.foreach(tf => {
      tf.textProperty.addListener(new ChangeListener[String]() {
        @Override
        def changed(observableValue: ObservableValue[_ <: String], s: String, s2: String) {
          //println("Changed from: " + s + " to: " + s2)
          if (!s2.equals(""))
            if (SudokuUtils.isAllDigits(s2)) {
              if (!SudokuUtils.isFromOne2Nine(s2))
                tf.setText(s)
            } else tf.setText(s)
        }
      })
    })
  })

  def startGame(event: ActionEvent) {
    // get the sudoku problem
    val sudokuBoard = SudokuUtils.getBoard(tf00.getText, tf01.getText, tf02.getText, tf03.getText, tf04.getText, tf05.getText, tf06.getText, tf07.getText, tf08.getText,
      tf10.getText, tf11.getText, tf12.getText, tf13.getText, tf14.getText, tf15.getText, tf16.getText, tf17.getText, tf18.getText,
      tf20.getText, tf21.getText, tf22.getText, tf23.getText, tf24.getText, tf25.getText, tf26.getText, tf27.getText, tf28.getText,
      tf30.getText, tf31.getText, tf32.getText, tf33.getText, tf34.getText, tf35.getText, tf36.getText, tf37.getText, tf38.getText,
      tf40.getText, tf41.getText, tf42.getText, tf43.getText, tf44.getText, tf45.getText, tf46.getText, tf47.getText, tf48.getText,
      tf50.getText, tf51.getText, tf52.getText, tf53.getText, tf54.getText, tf55.getText, tf56.getText, tf57.getText, tf58.getText,
      tf60.getText, tf61.getText, tf62.getText, tf63.getText, tf64.getText, tf65.getText, tf66.getText, tf67.getText, tf68.getText,
      tf70.getText, tf71.getText, tf72.getText, tf73.getText, tf74.getText, tf75.getText, tf76.getText, tf77.getText, tf78.getText,
      tf80.getText, tf81.getText, tf82.getText, tf83.getText, tf84.getText, tf85.getText, tf86.getText, tf87.getText, tf88.getText)

    // Solve
    val res = SudokuUtils.solve(sudokuBoard).get

    for (i <- 0 until 9) {
      for (j <- 0 until 9) {
        SudokuUtils.setTextOrElse(arrayTF(i)(j), res(i)(j))
      }
    }
  }

  def endGame(event: ActionEvent) {

    //======== Cách dùng JFoenix truyền thống =======//
    val confirmForm = new JFXDialog // dialog
    val dialogLayout = new JFXDialogLayout // thiết kế layout
    dialogLayout.setHeading(new Text("Xác nhận")) // tiêu đề
    dialogLayout.setBody(new Text("Em thật sự muốn thoát khỏi chương trình hả Phương Phương? 💦")) //nội dung

    // Hai nút lựa chọn
    val btnOK = new JFXButton("Thoát nha 👋 bye!")
    btnOK.setMinWidth(100)
    btnOK.setMinHeight(40)
    btnOK.setStyle("-fx-background-color:#ffa6a6") //màu nền đỏ

    val btnCancel = new JFXButton("Muốn ở lại cơ 💛")
    btnCancel.setMinWidth(100)
    btnCancel.setMinHeight(40)
    btnCancel.setStyle("-fx-background-color:#c8ffcf") //màu nền xanh

    btnCancel.setOnAction(e => {
      confirmForm.close // đóng dialog, không thoát nữa
    })

    btnOK.setOnAction(e => {
      Platform.exit // thoát chương trình
    })

    // thêm 2 nút vào danh sách
    val arrayBtn = new ArrayList[javafx.scene.Node]()
    arrayBtn.add(btnOK)
    arrayBtn.add(btnCancel)

    // thêm danh sách hai nút vào layout
    dialogLayout.setActions(arrayBtn)

    // set nội dung của dialog là layout
    confirmForm.setContent(dialogLayout)
    confirmForm.setTransitionType(JFXDialog.DialogTransition.BOTTOM) // hiệu ứng di chuyển từ dưới lên
    confirmForm.show(SudokuSolver.stage.getScene.getRoot.asInstanceOf[StackPane]) // lấy control cha là tấm nền chính của cả chương trình
  }

  def deleteGame(event: ActionEvent) {
    for (i <- 0 until 9) {
      for (j <- 0 until 9) {
        SudokuUtils.setNullText(arrayTF(i)(j))
      }
    }
  }
}