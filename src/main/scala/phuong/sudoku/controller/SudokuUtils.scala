package main.scala.phuong.sudoku.controller

import scalafx.scene.control.TextField

object SudokuUtils {

  def isAllDigits(x: String) = x forall Character.isDigit

  def isFromOne2Nine(x: String) = {
    val a = x.toInt
    if (a < 1 || a > 9)
      false
    else
      true
  }

  def getBoard(
      str00: String,
      str01: String,
      str02: String,
      str03: String,
      str04: String,
      str05: String,
      str06: String,
      str07: String,
      str08: String,
      str10: String,
      str11: String,
      str12: String,
      str13: String,
      str14: String,
      str15: String,
      str16: String,
      str17: String,
      str18: String,
      str20: String,
      str21: String,
      str22: String,
      str23: String,
      str24: String,
      str25: String,
      str26: String,
      str27: String,
      str28: String,
      str30: String,
      str31: String,
      str32: String,
      str33: String,
      str34: String,
      str35: String,
      str36: String,
      str37: String,
      str38: String,
      str40: String,
      str41: String,
      str42: String,
      str43: String,
      str44: String,
      str45: String,
      str46: String,
      str47: String,
      str48: String,
      str50: String,
      str51: String,
      str52: String,
      str53: String,
      str54: String,
      str55: String,
      str56: String,
      str57: String,
      str58: String,
      str60: String,
      str61: String,
      str62: String,
      str63: String,
      str64: String,
      str65: String,
      str66: String,
      str67: String,
      str68: String,
      str70: String,
      str71: String,
      str72: String,
      str73: String,
      str74: String,
      str75: String,
      str76: String,
      str77: String,
      str78: String,
      str80: String,
      str81: String,
      str82: String,
      str83: String,
      str84: String,
      str85: String,
      str86: String,
      str87: String,
      str88: String,
      ): Array[Array[Int]] = {
    val res = Array(Array(getIntOrZero(str00),getIntOrZero(str01),getIntOrZero(str02),getIntOrZero(str10),getIntOrZero(str11),getIntOrZero(str12),getIntOrZero(str20),getIntOrZero(str21),getIntOrZero(str22)),
        Array(getIntOrZero(str03),getIntOrZero(str04),getIntOrZero(str05),getIntOrZero(str13),getIntOrZero(str14),getIntOrZero(str15),getIntOrZero(str23),getIntOrZero(str24),getIntOrZero(str25)),
        Array(getIntOrZero(str06),getIntOrZero(str07),getIntOrZero(str08),getIntOrZero(str16),getIntOrZero(str17),getIntOrZero(str18),getIntOrZero(str26),getIntOrZero(str27),getIntOrZero(str28)),
        
        Array(getIntOrZero(str30),getIntOrZero(str31),getIntOrZero(str32),getIntOrZero(str40),getIntOrZero(str41),getIntOrZero(str42),getIntOrZero(str50),getIntOrZero(str51),getIntOrZero(str52)),
        Array(getIntOrZero(str33),getIntOrZero(str34),getIntOrZero(str35),getIntOrZero(str43),getIntOrZero(str44),getIntOrZero(str45),getIntOrZero(str53),getIntOrZero(str54),getIntOrZero(str55)),
        Array(getIntOrZero(str36),getIntOrZero(str37),getIntOrZero(str38),getIntOrZero(str46),getIntOrZero(str47),getIntOrZero(str48),getIntOrZero(str56),getIntOrZero(str57),getIntOrZero(str58)),
        
        Array(getIntOrZero(str60),getIntOrZero(str61),getIntOrZero(str62),getIntOrZero(str70),getIntOrZero(str71),getIntOrZero(str72),getIntOrZero(str80),getIntOrZero(str81),getIntOrZero(str82)),
        Array(getIntOrZero(str63),getIntOrZero(str64),getIntOrZero(str65),getIntOrZero(str73),getIntOrZero(str74),getIntOrZero(str75),getIntOrZero(str83),getIntOrZero(str84),getIntOrZero(str85)),
        Array(getIntOrZero(str66),getIntOrZero(str67),getIntOrZero(str68),getIntOrZero(str76),getIntOrZero(str77),getIntOrZero(str78),getIntOrZero(str86),getIntOrZero(str87),getIntOrZero(str88))        
        )
        res
  }
  
  def getIntOrZero(x: String)={
    if(x.equals(""))
      0
    else
      x.toInt
  }
  
  def solve(board: Array[Array[Int]], cell: Int = 0): Option[Array[Array[Int]]] = (cell%9, cell/9) match {
    case (r, 9) => Some(board)
    case (r, c) if board(r)(c) > 0 => solve(board, cell + 1)
    case (r, c) =>
      def cells(i: Int) = Seq(board(r)(i), board(i)(c), board(3*(r/3) + i/3)(3*(c/3) + i%3))
      def guess(x: Int) = solve(board.updated(r, board(r).updated(c, x)), cell + 1)  
      val used = board.indices.flatMap(cells)
      (1 to 9).diff(used).collectFirst(Function.unlift(guess))
  }
  
  def setTextOrElse(tf: TextField, value: Int):Unit={
    if(tf.getText.equals("")){
      tf.setStyle("-fx-background-color: #fffbc6; -fx-text-fill: red;")
      tf.setText(value.toString);
    }
  }
  
  def setNullText(tf: TextField):Unit={
      tf.setStyle("-fx-background-color: #fffbc6; -fx-text-fill: #00720b;")
      tf.setText("");
  }
}