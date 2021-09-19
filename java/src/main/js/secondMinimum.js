
let value = [2,1,3,4,5,6]

function findSecondMaximum(value) {

  let max = 0;
  let sMax = 0;
  for( let i = 0 ; i < value.length; i++) {

    if(value[i] > max) {
      sMax = max;
      max = value[i];
    } else if( sMax < max && value[i] > sMax) {
      sMax = value[i];
    }
  }

  return sMax;
}


console.log(findSecondMinimum(value))
