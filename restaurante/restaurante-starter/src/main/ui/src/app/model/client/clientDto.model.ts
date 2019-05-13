export class ClientDto {
    idCliente: number;
    name: string;
    lastName1: string;
    lastName2: string;
    comment: string;

    constructor() {
        this.idCliente = 0;
        this.name='';
        this.lastName1='';
        this.lastName2='';
        this.comment='';
    }
}