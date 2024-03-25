import { IRole } from "../role/role.model";

export interface IUser {
    id: number,
    firstName: string,
    lastName: string,
    email: string,
    photoUrl: string,
    roles: IRole[]
}