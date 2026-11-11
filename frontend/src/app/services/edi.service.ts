import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EdiService {
  private http = inject(HttpClient);
  private apiUrl = 'http://localhost:8080/api/v1';

  getAlerts(): Observable<string[]> {
    return this.http.get<string[]>(`${this.apiUrl}/alerts`);
  }

  askChat(message: string): Observable<{ response: string }> {
    return this.http.get<{ response: string }>(`${this.apiUrl}/chat`, {
      params: { message }
    });
  }

  ingestDocument(content: string): Observable<{ message: string }> {
    return this.http.post<{ message: string }>(`${this.apiUrl}/ingest/text`, { content });
  }
}
