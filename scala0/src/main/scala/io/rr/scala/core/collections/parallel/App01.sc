var i = 0
for(j <- 1 to 1000) i+=1
i
i = 0
for(j <- (1 to 1000).par) i+=1
i