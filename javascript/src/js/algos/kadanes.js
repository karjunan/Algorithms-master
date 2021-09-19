function kadanesAlgorithm(array) {
    if(array.length < 1) {
         return array[0];
    }
    var temp = [];
    temp.push(array[0]);
    var max = Number.MIN_VALUE;
    for(var i = 1 ; i < array.length; i++) {
        max = array[i] + temp[i-1];
        if(max < array[i]) {
            temp.push(array[i]);
        } else {
            temp.push(max)
        }
        console.log(temp);
    }
    max = Number.MIN_SAFE_INTEGER;
    for(var i of temp) {
        if(max < i) {
            max = i;
        }
    }
    return max;
  }

  let array = [
    3, 5, -9, 1,  3, -2,
    3, 4,  7, 2, -9,  6,
    3, 1, -5, 4
  ]

  let result = kadanesAlgorithm(array);
  console.log(result);