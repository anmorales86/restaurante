export class WaiterDto {
    idWaiter: number;
    name: string;
    lastName1: string;
    lastName2: string;

    constructor() {
        this.idWaiter = 0;
        this.name='';
        this.lastName1='';
        this.lastName2='';        
    }
}