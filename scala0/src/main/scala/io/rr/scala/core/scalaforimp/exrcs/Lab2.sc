def isVowel0(ch: Char) = {
  ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
}

def isVowel(ch: Char) = "aeiuo".contains(ch)

def vowels(s: String) = {
//  var result: String  = ""
//  for(c <- s) if (isVowel1(c)) result += c
//  str

  for(c <- s if isVowel(c)) yield c
}
vowels("vowels")

def vowels1(s: String): String = {
  if(s.length == 0) ""
  else {
    val ch = s(0)
    val rest = vowels1(s.substring(1))
    if (isVowel(ch)) ch + rest else rest
  }
}
vowels1("vowels")

def vowels2(s: String): String = {
  var i = 0
  var result = ""
  while (i < s.length) {
    if (isVowel(s(i))) result += s(i)
    i += 1
  }
  result
}
vowels2("vowels")

def vowelsChars(s: String, ignoreCase: Boolean = true): String = {
  if(ignoreCase) vowelsChars(s.toLowerCase, false)
  else for(c <- s if isVowel(c)) yield c
}

vowelsChars("vOwels")
vowelsChars("vOwels", ignoreCase = false)