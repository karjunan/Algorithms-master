
function sumRange(val) {
    if(val == 1) {
        return 1;
    }
    
    return val + sumRange(val-1)

}

let value = 4;
let result = sumRange(value);

console.log(result)