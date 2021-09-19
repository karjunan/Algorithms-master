
function sumZero(values) {

    var k = values.length-1;
    var i = 0;
    // console.log(values[k]- values[i]);
        while(i < k) {
            console.log("success i < k ", k-i)
            if((values[k] + values[i]) < 0) {    
                i++;
            } else if( values[k] + values[i] > 0) {
                k--;
            } else {
                console.log("values are matching");
                let array = [values[i], values[k]];
                return array;
            }
            
        }
        // if(i  > k || k == 0 || i >= values.length) {
        //     return [];
        // } 
    return [];
}

let val = [-4,-2,-1,0,1,2,3]
// let val = [-2,0,1,3]
let result = sumZero(val)
console.log(result);

export {sumZero};