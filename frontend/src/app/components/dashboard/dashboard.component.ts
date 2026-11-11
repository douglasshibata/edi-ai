import { Component, signal, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EdiService } from '../../services/edi.service';
import { interval } from 'rxjs';
import { startWith, switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent implements OnInit {
  private ediService = inject(EdiService);

  kpis = signal([
    { name: 'Receita Mensal', value: 'R$ 1.2M', trend: '+5%', color: 'text-green-600' },
    { name: 'Custo Operacional', value: 'R$ 450k', trend: '-2%', color: 'text-red-600' },
    { name: 'Churn Rate', value: '1.8%', trend: '-0.2%', color: 'text-blue-600' },
    { name: 'Satisfação (NPS)', value: '82', trend: '+3', color: 'text-purple-600' }
  ]);

  insights = signal([
    'Aumento projetado de 15% nas vendas para o próximo trimestre.',
    'Risco detectado de ruptura de estoque no item "X-900".',
    'Oportunidade de otimização tributária identificada na filial Sul.'
  ]);

  alerts = signal<string[]>([]);

  ngOnInit() {
    this.startAlertPolling();
  }

  startAlertPolling() {
    // Poll for alerts every 10 seconds
    interval(10000).pipe(
      startWith(0),
      switchMap(() => this.ediService.getAlerts())
    ).subscribe({
      next: (data) => {
        if (data && data.length > 0) {
          this.alerts.set(data);
        }
      },
      error: (err) => console.error('Erro ao buscar alertas:', err)
    });
  }
}
