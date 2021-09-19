
export class oddEven {
    constructor() {
    }


    reorderOddEven(values:  Array<number>) {
      let set = new Set();
      for(let i = 0 ; i < values.length; i++) {
        if((i % 2 == 0 && values[i] % 2 == 0) ||
          i % 2 != 0 && values[i] % 2 != 0 ) {
            set.add(i);
            continue;
        }
      }

      for(let i = 0 ; i < values.length; i++) {
        if(i % 2 == 0 && values[i] % 2 != 0) {
            let k = i+1;
            while(k < values.length && values[k] % 2 == 0 && !set.has(k) && !set.has(i) ) {
                let temp = values[i];
                values[i] = values[k];
                values[k] = temp;
                break;
            }
        }
        if(i % 2 == 1 && values[i] % 2 == 0) {
            let k = i+1;
            while(k < values.length && values[k] % 2 != 0 && !set.has(k) && !set.has(i) ) {
                let temp = values[i];
                values[i] = values[k];
                values[k] = temp;
                break;
            }
        }
        console.log(values);
        
      }
    }
}

const obj = new oddEven()

obj.reorderOddEven([42,43,44,45,46,47])
