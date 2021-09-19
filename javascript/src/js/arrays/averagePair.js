function averagePair(elements, avgValue) {

    var i = 0;
    var j = elements.length-1;

    while(i < j) {
        var sum = ((elements)[i] + elements[j])/2;
        // console.log("Average value is => " + sum)
        if( sum < avgValue) {
            i++;
        } else  if (sum > avgValue) {
            j--;
        } else {
            console.log("pair is ", elements[i], elements[j]+ "  => ", avgValue  + " =>  " + sum);
            return true;
        }
    }

    return false;
}

// let elements = [1,2,3]
// let elements = [1,3,3,5,6,7,10,12,19]
let elements = [-1,0,3,4,5,6]
let result = averagePair(elements,4.1)
console.log(result);