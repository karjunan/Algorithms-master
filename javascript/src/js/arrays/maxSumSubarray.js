function maxSubarraySum(values,val) {

    var i = 0;
    var j = 0;
    var sum = 0;
    var max = 0;
    var counter = 0 ;
    while(j < values.length) {
       while(counter < val) {
            sum = sum + values[j];
            j++;
            counter++;
            continue;
       } 
       counter = 0;
       if(max < sum ) {
           max = sum;
       }
       sum = 0;
       i++;
       j = i;
    }
    return max;
}


function maxSubarraySumV1(values,val) {
     var i = 0;
     var j = 0;
     var sum=0;
     var max=0;
     var counter = 0;
     while(j < values.length) {

        if(counter < val) {
            sum = sum + values[j];
            counter++;
            j++;
            console.log("Sum is => " + sum);
            continue;
        }
        
        if(max < sum) {
            max = sum;
        }
        sum = sum - values[i];
        sum = sum + values[j];
        j++;
        i++;
     }

     if(max < sum) {
        max = sum;
    }
    return max;

}

let values = [1,2,5,2,8,1,5]
// let values = [4,2,1,6]
// let values = []

let result = maxSubarraySumV1(values,2)

console.log("Max is " + result)