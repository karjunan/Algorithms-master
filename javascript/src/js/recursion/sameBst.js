function sameBsts(arrayOne, arrayTwo) {
    if(arrayOne.length !== arrayTwo.length) {
        return false;
    }
    if(arrayOne[0] !== arrayTwo[0]) {
        return false;
    }
    // console.log(arrayOne,arrayTwo)
    var result = helper(arrayOne, arrayTwo)
    console.log(result);
    return result;
}

function helper(arrayOne,arrayTwo) {
    console.log("Array Lengths => " , arrayOne, arrayTwo);
     
    if(arrayOne.length <= 1 && arrayTwo.length <= 1) {
       
        return true;
    }

    if(arrayOne[0] != arrayTwo[0]) {
        return  false;
    }
    
    var smallOne = findSmallerAndLarger(arrayOne,true) 
    var smallTwo = findSmallerAndLarger(arrayTwo,true)
    console.log("Small values", smallOne, smallTwo)
    if(smallOne[0] != smallTwo[0]) {
        return  false;
    }
   
    var largeOne = findSmallerAndLarger(arrayOne,false) 
    var largeTwo = findSmallerAndLarger(arrayTwo,false)
    if(largeOne[0] != largeTwo[0]) {
        return  false;
    }
    console.log("Large values", largeOne, largeTwo)
    return helper(largeOne,largeTwo) && helper(smallOne,smallTwo);
    
}

function findSmallerAndLarger(array,flag) {
    if(array.length === 1) {
        return array;
    }
    var first = array[0];
    var i = 1;
    var result = []
    while( i < array.length  ) {
        if(flag) {
            if(array[i] >= array[0]) {
                result.push(array[i]);
            }
        } else {
            if(array[i] < array[0]) {
                result.push(array[i]);
            } 
        }
        i++;
    }
    console.log(result);
    return result;
}


// let arrayOne = [10, 15, 8, 12, 94, 81, 5, 2, 11]
// let arrayTwo = [10, 8, 5, 15, 2, 12, 11, 94, 81]

// let arrayOne =[5, 2, -1, 100, 45, 12, 8, -1, 8, 10, 15, 8, 12, 94, 81, 2, -34]
// let arrayTwo =  [5, 8, 10, 15, 2, 8, 12, 45, 100, 2, 12, 94, 81, -1, -1, -34, 8]

// let arrayOne = [10, 15, 8, 12, 94, 81, 5, 2, -1, 100, 45, 12, 9, -1, 8, 2, -34]
// let arrayTwo = [10, 8, 5, 15, 2, 12, 94, 81, -1, -1, -34, 8, 2, 9, 12, 45, 100]

// let arrayOne = [10, 15, 8, 12, 94, 81, 5, 2, 10]
// let arrayTwo = [10, 8, 5, 15, 2, 10, 12, 94, 81]

let arrayOne = [10, 15, 8, 12, 94, 81, 5, 2, -1, 101, 45, 12, 8, -1, 8, 2, -34]
let arrayTwo = [10, 8, 5, 15, 2, 12, 94, 81, -1, -1, -34, 8, 2, 8, 12, 45, 100]

var result = sameBsts(arrayOne,arrayTwo);
console.log("Whats the result = > " + result)
// findSmallerAndLarger(arrayOne,true)
// findSmallerAndLarger(arrayOne,false)