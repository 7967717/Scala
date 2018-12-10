val wordFrequencies = ("habitual", 6) :: ("and", 56) :: ("consuetudinary", 2) ::
  ("additionally", 27) :: ("homely", 5) :: ("society", 13) :: Nil
def wordsWithoutOutliers(wordFrequencies: Seq[(String, Int)]): Seq[String] =
  wordFrequencies.filter(wf => wf._2 > 3 && wf._2 < 25).map(_._1)
wordsWithoutOutliers(wordFrequencies)


def wordsWithoutOutliers1(wordFrequencies: Seq[(String, Int)]): Seq[String] =
  for ((w, f) <- wordFrequencies if f > 3 && f < 25) yield w
wordsWithoutOutliers1(wordFrequencies)


def wordsWithoutOutliers2(wordFrequencies: Seq[(String, Int)]): Seq[String] =
  wordFrequencies
    .filter {
      case (_, f) => f > 3 && f < 25
    }
    .map {
      case (w, _) => w
    }
wordsWithoutOutliers2(wordFrequencies)


def wordsWithoutOutliers3(wordFrequencies: Seq[(String, Int)]): Seq[String] =
  wordFrequencies.collect {
    case (word, freq) if freq > 3 && freq < 25 => word
  }
wordsWithoutOutliers3(wordFrequencies)


