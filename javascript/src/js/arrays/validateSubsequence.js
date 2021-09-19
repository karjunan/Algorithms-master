function isValidSubsequence1(arr,sequence) {
    var i = 0;
    var j = 0;
    while(i < arr.length && j < sequence.length) {
        if(arr[i] === sequence[j]) {
            j++;
        }
        i++;
    }
    if(j === sequence.length)  {
        return true;
    }
    return false;
}
function isValidSubsequence(arr, sequence) {
    
    var i = 0
    var j = 0;
    if(sequence.length > arr.length) {
        return false;
    }

    while(i < arr.length && j < sequence.length) {
        if(arr[i] != sequence[j]) {
            i++;
        }
        if(arr[i] === sequence[j]) {
            console.log("Equal Value => ", arr[i],sequence[j]);
            j++;
            i++;
        }
        if(j >= sequence.length) {
            break;
        }
    }
    console.log(j);

    if(j >= sequence.length) {
        console.log(arr[i] , sequence[j-1])
        return true;
    }

    return false;
  }

//   let array =  [5, 1, 22, 25, 6, -1, 8, 10]
//   let sequence = [5, 1, 22, 22, 6, -1, 8, 10]
let array = [5, 1, 22, 25, 6, -1, 8, 10]
let sequence = [1, 6, -1, 10]
//   let result = isValidSubsequence(array,sequence);
  let result = isValidSubsequence1(array,sequence)
  console.log("Is a valid sequence => ", result )