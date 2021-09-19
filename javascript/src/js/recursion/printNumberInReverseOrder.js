
function printNumberReverseOrder(val,start) {
        // console.log("Start value is => " + start)
        if(start == val.length) {
            return
        } 
        start = start+1;
        printNumberReverseOrder(val,start)
        console.log(val[start])
        
        
}


let number = [1,2,3,4,5]
printNumberReverseOrder(number,-1);