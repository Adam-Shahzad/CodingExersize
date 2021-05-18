package com.coding.exersises

case class Fragment(matchTime: Int, team1PointsTotal: Int, team2PointsTotal: Int, whoScored: Int, pointsScored: Int)

object Fragment {

  def extractSegmentFromBinaryToInt(input: Int, start: Int, end: Int): Int = {
    Integer.parseInt(Integer.toBinaryString(input).reverse.padTo(32, '0').reverse.substring(start,end), 2)
  }

  def isValid(fragment: Fragment): Boolean = {
    fragment.matchTime == 0 || fragment.pointsScored == 0
  }


    def apply(input: Int): Fragment = {
      val matchTime        = extractSegmentFromBinaryToInt(input, 1,13)
      val team1PointsTotal = extractSegmentFromBinaryToInt(input,13, 21)
      val team2PointsTotal = extractSegmentFromBinaryToInt(input,21, 29)
      val whoScored        = extractSegmentFromBinaryToInt(input,29, 30)
      val pointsScored     = extractSegmentFromBinaryToInt(input,30, 32)
      new Fragment(matchTime, team1PointsTotal, team2PointsTotal, whoScored, pointsScored)
  }
}