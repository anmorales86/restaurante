export class TableRestDto {
    idTable: number;
    maxComensaNumber: number;
    location: string;

    constructor() {
        this.idTable = 0;
        this.maxComensaNumber=0;
        this.location='';        
    }
}