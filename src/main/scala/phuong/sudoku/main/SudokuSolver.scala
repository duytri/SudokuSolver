package main.scala.phuong.sudoku.main

import java.io.IOException
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafxml.core.FXMLView
import scalafxml.core.NoDependencyResolver
import scalafx.scene.image.Image
import scalafx.scene.layout.StackPane
import scalafx.stage.StageStyle

object SudokuSolver extends JFXApp {
  // đọc file thiết kế giao diện
  val resource = getClass.getResource("/main/scala/phuong/sudoku/view/SudokuUI.fxml")
  if (resource == null) {
    throw new IOException("Cannot load resource: SudokuUI.fxml")
  }

  // dựng giao diện lại dựa trên file thiết kế đã đọc
  val root = FXMLView(resource, NoDependencyResolver)
  val stackPane = new StackPane() // StackPane bao ngoài cùng để các dialog sử dụng làm control tham chiếu
  stackPane.getChildren.add(root)

  stage = new PrimaryStage {
    title = "CHUONG TRINH GIAI SUDOKU - Phuong Phuong"
    icons += new Image("main/scala/phuong/sudoku/view/icon.png")
    scene = new Scene(stackPane)
    resizable = false
    //initStyle(StageStyle.UNDECORATED)
  }
}