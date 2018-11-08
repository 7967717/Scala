val revert: Any => Any = {
  case (x, (y, z)) => revert((x, y), z)
  case x => x
}

revert((0, (1, (2, (3, (4, 5))))))


val revert1: Any => Any = {
  case ((x, y), z) => revert1(x, (y, z))
//  case (a, (b, (c, d))) => revert1(a, (b, (c, (d)))
  case x => x
}
revert1((0, (1, (2, (3, (4, 5))))))
revert1((0, 1), (2, 3))