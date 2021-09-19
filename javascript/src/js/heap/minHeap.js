class MinHeap {

    constructor(array) {
        this.array = this.buildHeap(array);
        this.length = array.length;
    }

    buildHeap(array) {
        var parent = Math.floor((array.length-1)/2)
        while(parent >= 0) {
            this.shiftDown(parent);
            parent--;
        }
    }

    insert(value) {
        array.push(value);
        this.shiftUp(array.length-1)
    }
    
    shiftDown(i) {
        // var parent = Math.floor((i-1)/2) -1 ;
        
        while(i < array.length) {
            var left =   (2*i) + 1;
            var right =  (2*i) + 2;
            var minIndex = -1
            if(left >= array.length || right >= array.length) {
                return;
            }
            if(array[left] < array[right]) {
                minIndex = left;
            } else {
                minIndex = right;
            }

            if(array[i] > array[minIndex]) {
                this.swap(array,i,minIndex)
            } else {
                break;
            }

            i = minIndex;
        }
    }

    shiftUp(i) {
         var parent = Math.floor((i-1)/2) ;
         while(parent >= 0 && array[i] < array[parent]) {
             this.swap(array,i,parent);
             i = parent;
             parent = Math.floor((i-1)/2);
         }
          
    }

    print() {
        console.log(array);
    }

    swap(arr,i,j) {
        var temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    remove() {
        this.swap(array,0,array.length-1);
        array.pop();
        this.shiftDown(0)
    }
    peek() {
        console.log(array);
        if(array.length > 0) {
            console.log("Peak value =>", array[0]);
            return array[0];
        }  
            
        return -1
      }
   
}
  //   49
 // 12   53
//13  1 4 45

//       1
//   2       4
// 9   5      13 12 
//45 53

// {"arguments": [76], "method": "insert"},
// {"arguments": [], "method": "peek"},
// {"arguments": [], "method": "remove"},
// {"arguments": [], "method": "peek"},
// {"arguments": [], "method": "remove"},
// {"arguments": [], "method": "peek"},
// {"arguments": [87], "method": "insert"}

// let array = [9,5,12,53,1,13,4,45,2]
// let array = [48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41]
let array = [
    544,
    -578,
    556,
    713,
    -655,
    -359,
    -810,
    -731,
    194,
    -531,
    -685,
    689,
    -279,
    -738,
    886,
    -54,
    -320,
    -500,
    738,
    445,
    -401,
    993,
    -753,
    329,
    -396,
    -924,
    -975,
    376,
    748,
    -356,
    972,
    459,
    399,
    669,
    -488,
    568,
    -702,
    551,
    763,
    -90,
    -249,
    -45,
    452,
    -917,
    394,
    195,
    -877,
    153,
    153,
    788,
    844,
    867,
    266,
    -739,
    904,
    -154,
    -947,
    464,
    343,
    -312,
    150,
    -656,
    528,
    61,
    94,
    -581
  ]
let heap = new MinHeap(array);
heap.buildHeap(array)
console.log(array);
heap.peek();
// heap.shiftDown();
// heap.insert(76);
// heap.print()
// heap.peek();
// heap.remove()
// heap.print()
// heap.peek()
// heap.remove()
// heap.peek()
// heap.insert(87);
// heap.print()