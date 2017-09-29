import forcomp.loadDictionary

type Word = String
type Sentence = List[Word]
type Occurrences = List[(Char, Int)]
val dictionary: List[Word] = loadDictionary
def wordOccurrences(w: Word): Occurrences =
  w.toLowerCase.groupBy(ch => ch).toList.map({
  case (ch, str) => (ch, str.length)
}).sorted
wordOccurrences("apple")
wordOccurrences(List("org", "bnn", "pnp", "app", "pear").mkString)
lazy val dictionaryByOccurrences: Map[Occurrences, List[Word]] = dictionary.groupBy(wordOccurrences).withDefaultValue(List())
def wordAnagrams(word: Word): List[Word] = dictionaryByOccurrences(wordOccurrences(word))
wordAnagrams("player")
wordAnagrams("qwer")



