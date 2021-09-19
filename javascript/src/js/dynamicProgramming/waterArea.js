function waterArea(heights) {
    console.log(heights);

    let minArray = [];
    minArray.fill(0);
    let maxArray= [];
    maxArray.fill(0);

    minArray[0] = 0
    for(var i = 1; i < heights.length; i++) {
       if(heights[i-1] > minArray[i-1]) {
           minArray[i] = heights[i-1]; 
       } else {
           minArray[i] = minArray[i-1];
       }
    }

    maxArray[heights.length-1] = 0;
    for(var i = heights.length-2; i >= 0; i--) {
        if(heights[i+1] > maxArray[i+1]) {
            maxArray[i] = heights[i+1]; 
        } else {
            maxArray[i] = maxArray[i+1];
        }
     }

     var result = [];
     result.fill(0);
     for(var i  in heights) {
        var min = Math.min(minArray[i],maxArray[i]);
        if(heights[i] < min) {
            result[i] = min - heights[i];
        } else {
            result[i] = 0;
        }
     }
    console.log("Min Array => " ,   minArray);
    console.log("Max Array => " ,   maxArray);
    console.log("Final Output => " , result)

    var out = +result.reduce((v, c) => c + v);
    console.log("Final Sum => ", out)
    return out;
  }
  

let array = [
    0,  8, 0, 0, 5, 0,
    0, 10, 0, 0, 1, 1,
    0,  3
  ]

  let result = waterArea(array);
  console.log("Final Result is => " , result);