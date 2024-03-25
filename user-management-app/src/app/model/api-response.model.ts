export interface ApiResponse<T> {
    ok: boolean;
    message: string;
    body: T;
}