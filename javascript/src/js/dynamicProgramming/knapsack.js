function knapSack(items,max) {

	var value = []
	var weight = []
	for(let i = 0 ; i < items.length; i++) {
		weight.push(items[i][1])
		value.push(items[i][0])
	}
	console.log(weight);
	console.log(value);
   var row = []
   for(let i = 0 ; i <= weight.length; i++) {
       row[i] = new Array(max+1);
       row[i].fill(0);
    //    console.log(row[i])
   }
   console.log(row)

   var index = 0;
   
   for(var i =  1 ; i < row.length; i++) {
    console.log("------Interation row Started for --------" , i)
       for(var j = 1 ; j < row[i].length; j++) {
            let earlyWeightIndex = j - weight[index];
            let currentValue = value[index];
            if(earlyWeightIndex < 0) {
                row[i][j] = Math.max(row[i-1][j], row[i][j-1])
                continue;
            }
            // console.log("Math => ", (currentValue+row[i-1][earlyWeightIndex]))
            // console.log("Math 1 => ",row[i-1][j])
            let result = Math.max((currentValue+row[i-1][earlyWeightIndex]), row[i-1][j])
            // console.log("Result is => ", result)
            row[i][j] = result;
            
       }
       index++;
       console.log("------Interation row Completed--------", row[i])
   }
//    console.log(row);
   var result = []
   var arr = []
   var colLength = max;
   var rowLength = weight.length;
   result.push(row[rowLength][colLength])
   console.log("Row and column => " , row[rowLength][colLength], rowLength,colLength);
   while( rowLength > 0 && colLength > 0 ) {
    //    console.log("Column length => " , colLength)
       if(row[rowLength][colLength] === row[rowLength-1][colLength]) {
        console.log("Row Length -> ", rowLength, row[rowLength][colLength])
        rowLength = rowLength - 1;
       } else {
           console.log("Elements are not same", rowLength, row[rowLength][colLength], row[rowLength-1][colLength])
          
           if(row[rowLength-1][colLength] <= 0) {
               arr.push(rowLength-1);
               break;
           }
           arr.push(rowLength-1)
           colLength = colLength - weight[rowLength-1];
           rowLength = rowLength-1
       }
    //    console.log(result, colLength)
   }   
   result.push(arr)
   console.log(result);
   return result;
  
}


// let max=7;
// let weight = [1,3,4,5]
// let value  = [1,4,5,7]

// let capacity=10;
// let items = [[1,2],[4,3],[5,6],[6,7]]

// let capacity=7;
// let items = [[1,1],[4,3],[5,4],[7,5]]
// let weight = [2,3,4,5]
// let value  = [1,2,5,6]

// let capacity=10;
// let items = [[10,5],[13,7],[19,9],[4,2]]


// let capacity=10;
// let items = [ [ 1,2 ], [ 4,3 ], [ 5,6 ], [ 6,7 ] ]

// let capacity=200
// let items = [
//     [ 465, 100 ],  [ 400, 85 ],
//     [ 255, 55 ],   [ 350, 45 ],
//     [ 650, 130 ],  [ 1000, 190 ],
//     [ 455, 100 ],  [ 100, 25 ],
//     [ 1200, 190 ], [ 320, 65 ],
//     [ 750, 100 ],  [ 50, 45 ],
//     [ 550, 65 ],   [ 100, 50 ],
//     [ 600, 70 ],   [ 255, 40 ]
//   ]

let capacity=200;
let items = [
    [ 465, 100 ],  [ 400, 85 ],
    [ 255, 55 ],   [ 350, 45 ],
    [ 650, 130 ],  [ 1000, 190 ],
    [ 455, 100 ],  [ 100, 25 ],
    [ 1200, 190 ], [ 320, 65 ],
    [ 750, 100 ],  [ 50, 45 ],
    [ 550, 65 ],   [ 100, 50 ],
    [ 600, 70 ],   [ 240, 40 ]
  ]

// let max=10;
// let weight = [5,7,9,2]
// let value  = [10,13,19,4]


let result = knapSack(items,capacity);
console.log("Final Output => ", result)