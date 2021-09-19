

export class Frequency {

    private frequencyEven(values:Array<number>) {
       let size = values.length; 
       let left = 0;
       let right = size-1;
       for( let i = 0 ; i < size; i++) {
            while(values[left] % 2 == 0 && left <= right) {
                left++;
                continue;
            }
            while(values[right] % 2 == 0 && right >= left ) {
                right--;
                continue;
            }
       console.log('left = ', left + ' :  right = ', right )     
        if(left >= right || right <= left) {
            break; 
        }

       } 

    }

    private frequencyOdd(values:Array<number>) {

    }

    frequency(values: Array<number>) {
        this.frequencyEven(values);
        this.frequencyOdd(values);

    }


}

export let arr = [4, 3, 2, 1, 2, 4]
const obj = new Frequency();
obj.frequency(arr);
