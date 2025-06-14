<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>영화관 관리자 대시보드</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.9.1/chart.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            padding: 20px;
        }
        
        .dashboard-container {
            max-width: 1400px;
            margin: 0 auto;
            background: rgba(255, 255, 255, 0.95);
            border-radius: 20px;
            box-shadow: 0 20px 40px rgba(0,0,0,0.1);
            overflow: hidden;
        }
        
        .header {
            background: linear-gradient(135deg, #1e3c72 0%, #2a5298 100%);
            color: white;
            padding: 30px;
            text-align: center;
        }
        
        .header h1 {
            font-size: 2.5em;
            margin-bottom: 10px;
            text-shadow: 2px 2px 4px rgba(0,0,0,0.3);
        }
        
        .header p {
            font-size: 1.1em;
            opacity: 0.9;
        }
        
        .main-content {
            padding: 30px;
        }
        
        .stats-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 20px;
            margin-bottom: 30px;
        }
        
        .stat-card {
            background: white;
            border-radius: 15px;
            padding: 25px;
            box-shadow: 0 8px 25px rgba(0,0,0,0.1);
            border-left: 5px solid;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }
        
        .stat-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 12px 30px rgba(0,0,0,0.15);
        }
        
        .stat-card.revenue { border-left-color: #10B981; }
        .stat-card.bookings { border-left-color: #3B82F6; }
        .stat-card.users { border-left-color: #F59E0B; }
        .stat-card.utilization { border-left-color: #EF4444; }
        
        .stat-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 15px;
        }
        
        .stat-title {
            font-size: 0.9em;
            color: #6B7280;
            font-weight: 600;
            text-transform: uppercase;
            letter-spacing: 0.5px;
        }
        
        .stat-icon {
            font-size: 1.5em;
            opacity: 0.6;
        }
        
        .stat-value {
            font-size: 2.2em;
            font-weight: bold;
            color: #1F2937;
            margin-bottom: 8px;
        }
        
        .stat-change {
            font-size: 0.85em;
            font-weight: 600;
        }
        
        .stat-change.positive { color: #10B981; }
        .stat-change.negative { color: #EF4444; }
        
        .charts-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(450px, 1fr));
            gap: 30px;
            margin-bottom: 30px;
        }
        
        .chart-container {
            background: white;
            border-radius: 15px;
            padding: 25px;
            box-shadow: 0 8px 25px rgba(0,0,0,0.1);
        }
        
        .chart-title {
            font-size: 1.3em;
            font-weight: bold;
            color: #1F2937;
            margin-bottom: 20px;
            display: flex;
            align-items: center;
            gap: 10px;
        }
        
        .chart-wrapper {
            position: relative;
            height: 300px;
        }
        
        .table-container {
            background: white;
            border-radius: 15px;
            padding: 25px;
            box-shadow: 0 8px 25px rgba(0,0,0,0.1);
            overflow-x: auto;
        }
        
        .data-table {
            width: 100%;
            border-collapse: collapse;
        }
        
        .data-table th,
        .data-table td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #E5E7EB;
        }
        
        .data-table th {
            background-color: #F9FAFB;
            font-weight: 600;
            color: #374151;
            text-transform: uppercase;
            font-size: 0.85em;
            letter-spacing: 0.5px;
        }
        
        .data-table tbody tr:hover {
            background-color: #F3F4F6;
        }
        
        .period-selector {
            display: flex;
            gap: 10px;
            margin-bottom: 20px;
        }
        
        .period-btn {
            padding: 8px 16px;
            border: 2px solid #E5E7EB;
            background: white;
            border-radius: 8px;
            cursor: pointer;
            transition: all 0.3s ease;
            font-weight: 500;
        }
        
        .period-btn.active {
            background: #3B82F6;
            color: white;
            border-color: #3B82F6;
        }
        
        .period-btn:hover:not(.active) {
            border-color: #3B82F6;
            color: #3B82F6;
        }
        
        @media (max-width: 768px) {
            .charts-grid {
                grid-template-columns: 1fr;
            }
            
            .stats-grid {
                grid-template-columns: 1fr;
            }
            
            .header h1 {
                font-size: 2em;
            }
        }
    </style>
</head>
<body>
    <%
        // 샘플 데이터 생성 (실제로는 데이터베이스에서 조회)
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.KOREA);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd");
        
        // 오늘의 주요 지표
        long todayRevenue = 2250000;
        int todayBookings = 95;
        int newUsers = 82;
        double avgUtilization = 78.4;
        
        // 일별 매출 데이터 (최근 7일)
        String[] dates = {"06/09", "06/10", "06/11", "06/12", "06/13", "06/14", "06/15"};
        long[] revenues = {1200000, 950000, 1450000, 1650000, 1850000, 2100000, 2250000};
        int[] bookings = {45, 32, 58, 62, 71, 89, 95};
        
        // 인기 영화 데이터
        String[] movieTitles = {"범죄도시4", "인사이드 아웃 2", "퓨리오사", "배드 보이즈", "콰이어트 플레이스"};
        int[] movieBookings = {156, 134, 98, 87, 76};
        long[] movieRevenues = {4200000, 3800000, 2900000, 2400000, 2100000};
        
        // 상영관 이용률 데이터
        String[] cinemaNames = {"1관 (IMAX)", "2관 (일반)", "3관 (4DX)", "4관 (일반)", "5관 (일반)"};
        double[] utilizationRates = {92.0, 78.0, 85.0, 71.0, 66.0};
        int[] totalSeats = {300, 250, 200, 280, 220};
        
        // 시간대별 예매 데이터
        String[] timeSlots = {"10:00", "13:00", "16:00", "19:00", "22:00"};
        int[] timeBookings = {45, 78, 92, 134, 89};
        
        // 장르별 분포 데이터
        String[] genres = {"액션", "애니메이션", "스릴러", "코미디", "드라마"};
        int[] genreCounts = {45, 32, 28, 25, 18};
    %>
    
    <div class="dashboard-container">
        <div class="header">
            <h1><i class="fas fa-film"></i> 영화관 관리자 대시보드</h1>
            <p>실시간 예매 현황 및 매출 분석 | 최종 업데이트: <%= new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm").format(new Date()) %></p>
        </div>
        
        <div class="main-content">
            <!-- 주요 지표 카드 -->
            <div class="stats-grid">
                <div class="stat-card revenue">
                    <div class="stat-header">
                        <span class="stat-title">오늘 매출</span>
                        <i class="fas fa-won-sign stat-icon"></i>
                    </div>
                    <div class="stat-value"><%= currencyFormat.format(todayRevenue) %></div>
                    <div class="stat-change positive">
                        <i class="fas fa-arrow-up"></i> 12.5%
                    </div>
                </div>
                
                <div class="stat-card bookings">
                    <div class="stat-header">
                        <span class="stat-title">오늘 예매 건수</span>
                        <i class="fas fa-ticket-alt stat-icon"></i>
                    </div>
                    <div class="stat-value"><%= todayBookings %>건</div>
                    <div class="stat-change positive">
                        <i class="fas fa-arrow-up"></i> 8.3%
                    </div>
                </div>
                
                <div class="stat-card users">
                    <div class="stat-header">
                        <span class="stat-title">신규 사용자</span>
                        <i class="fas fa-users stat-icon"></i>
                    </div>
                    <div class="stat-value"><%= newUsers %>명</div>
                    <div class="stat-change positive">
                        <i class="fas fa-arrow-up"></i> 15.2%
                    </div>
                </div>
                
                <div class="stat-card utilization">
                    <div class="stat-header">
                        <span class="stat-title">평균 상영관 이용률</span>
                        <i class="fas fa-chart-pie stat-icon"></i>
                    </div>
                    <div class="stat-value"><%= String.format("%.1f", avgUtilization) %>%</div>
                    <div class="stat-change negative">
                        <i class="fas fa-arrow-down"></i> 2.1%
                    </div>
                </div>
            </div>
            
            <!-- 차트 섹션 -->
            <div class="charts-grid">
                <!-- 일별 매출 추이 -->
                <div class="chart-container">
                    <div class="chart-title">
                        <i class="fas fa-chart-line"></i>
                        일별 매출 추이 (최근 7일)
                    </div>
                    <div class="period-selector">
                        <button class="period-btn active" onclick="changePeriod('week', this)">주간</button>
                        <button class="period-btn" onclick="changePeriod('month', this)">월간</button>
                        <button class="period-btn" onclick="changePeriod('year', this)">연간</button>
                    </div>
                    <div class="chart-wrapper">
                        <canvas id="revenueChart"></canvas>
                    </div>
                </div>
                
                <!-- 인기 영화 순위 -->
                <div class="chart-container">
                    <div class="chart-title">
                        <i class="fas fa-star"></i>
                        인기 영화 TOP 5 (예매 건수)
                    </div>
                    <div class="chart-wrapper">
                        <canvas id="movieChart"></canvas>
                    </div>
                </div>
                
                <!-- 상영관 이용률 -->
                <div class="chart-container">
                    <div class="chart-title">
                        <i class="fas fa-building"></i>
                        상영관별 이용률
                    </div>
                    <div class="chart-wrapper">
                        <canvas id="cinemaChart"></canvas>
                    </div>
                </div>
                
                <!-- 시간대별 예매 현황 -->
                <div class="chart-container">
                    <div class="chart-title">
                        <i class="fas fa-clock"></i>
                        시간대별 예매 현황
                    </div>
                    <div class="chart-wrapper">
                        <canvas id="timeChart"></canvas>
                    </div>
                </div>
                
                <!-- 장르별 분포 (도넛 차트) -->
                <div class="chart-container">
                    <div class="chart-title">
                        <i class="fas fa-chart-pie"></i>
                        장르별 예매 분포
                    </div>
                    <div class="chart-wrapper">
                        <canvas id="genreChart"></canvas>
                    </div>
                </div>
            </div>
            
            <!-- 상세 데이터 테이블 -->
            <div class="table-container">
                <div class="chart-title">
                    <i class="fas fa-table"></i>
                    영화별 상세 통계
                </div>
                <table class="data-table">
                    <thead>
                        <tr>
                            <th>순위</th>
                            <th>영화 제목</th>
                            <th>예매 건수</th>
                            <th>매출</th>
                            <th>평균 이용률</th>
                            <th>상영 횟수</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for(int i = 0; i < movieTitles.length; i++) { %>
                        <tr>
                            <td><%= i + 1 %></td>
                            <td><strong><%= movieTitles[i] %></strong></td>
                            <td><%= movieBookings[i] %>건</td>
                            <td><%= currencyFormat.format(movieRevenues[i]) %></td>
                            <td><%= String.format("%.1f", utilizationRates[i % utilizationRates.length]) %>%</td>
                            <td><%= (movieBookings[i] / 10) + 15 %>회</td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    
    <script>
        // 차트 데이터 준비
        const dates = <%= java.util.Arrays.toString(dates) %>;
        const revenues = <%= java.util.Arrays.toString(revenues) %>;
        const bookingsData = <%= java.util.Arrays.toString(bookings) %>;
        const movieTitles = <%= java.util.Arrays.toString(movieTitles) %>;
        const movieBookings = <%= java.util.Arrays.toString(movieBookings) %>;
        const cinemaNames = <%= java.util.Arrays.toString(cinemaNames) %>;
        const utilizationRates = <%= java.util.Arrays.toString(utilizationRates) %>;
        const timeSlots = <%= java.util.Arrays.toString(timeSlots) %>;
        const timeBookings = <%= java.util.Arrays.toString(timeBookings) %>;
        const genres = <%= java.util.Arrays.toString(genres) %>;
        const genreCounts = <%= java.util.Arrays.toString(genreCounts) %>;
        
        // 차트 색상 팔레트
        const colors = {
            primary: '#3B82F6',
            success: '#10B981',
            warning: '#F59E0B',
            danger: '#EF4444',
            purple: '#8B5CF6',
            gradient: ['#667eea', '#764ba2', '#f093fb', '#f5576c', '#4facfe']
        };
        
        // 1. 일별 매출 추이 차트
        const revenueCtx = document.getElementById('revenueChart').getContext('2d');
        new Chart(revenueCtx, {
            type: 'line',
            data: {
                labels: dates,
                datasets: [{
                    label: '매출 (원)',
                    data: revenues,
                    borderColor: colors.primary,
                    backgroundColor: colors.primary + '20',
                    fill: true,
                    tension: 0.4,
                    pointBackgroundColor: colors.primary,
                    pointBorderColor: '#fff',
                    pointBorderWidth: 2,
                    pointRadius: 6
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                plugins: {
                    legend: {
                        display: false
                    }
                },
                scales: {
                    y: {
                        beginAtZero: true,
                        ticks: {
                            callback: function(value) {
                                return '₩' + (value/1000000).toFixed(1) + 'M';
                            }
                        }
                    }
                },
                elements: {
                    point: {
                        hoverRadius: 8
                    }
                }
            }
        });
        
        // 2. 인기 영화 순위 차트
        const movieCtx = document.getElementById('movieChart').getContext('2d');
        new Chart(movieCtx, {
            type: 'bar',
            data: {
                labels: movieTitles,
                datasets: [{
                    label: '예매 건수',
                    data: movieBookings,
                    backgroundColor: colors.gradient,
                    borderColor: colors.gradient.map(color => color + 'CC'),
                    borderWidth: 2,
                    borderRadius: 8,
                    borderSkipped: false
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                plugins: {
                    legend: {
                        display: false
                    }
                },
                scales: {
                    y: {
                        beginAtZero: true,
                        ticks: {
                            callback: function(value) {
                                return value + '건';
                            }
                        }
                    }
                }
            }
        });
        
        // 3. 상영관 이용률 차트
        const cinemaCtx = document.getElementById('cinemaChart').getContext('2d');
        new Chart(cinemaCtx, {
            type: 'doughnut',
            data: {
                labels: cinemaNames,
                datasets: [{
                    data: utilizationRates,
                    backgroundColor: colors.gradient,
                    borderColor: '#fff',
                    borderWidth: 3
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                plugins: {
                    legend: {
                        position: 'bottom'
                    }
                }
            }
        });
        
        // 4. 시간대별 예매 현황 차트
        const timeCtx = document.getElementById('timeChart').getContext('2d');
        new Chart(timeCtx, {
            type: 'radar',
            data: {
                labels: timeSlots,
                datasets: [{
                    label: '예매 건수',
                    data: timeBookings,
                    borderColor: colors.success,
                    backgroundColor: colors.success + '20',
                    pointBackgroundColor: colors.success,
                    pointBorderColor: '#fff',
                    pointBorderWidth: 2,
                    fill: true
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                plugins: {
                    legend: {
                        display: false
                    }
                },
                scales: {
                    r: {
                        beginAtZero: true,
                        max: Math.max(...timeBookings) + 20
                    }
                }
            }
        });
        
        // 5. 장르별 분포 차트
        const genreCtx = document.getElementById('genreChart').getContext('2d');
        new Chart(genreCtx, {
            type: 'pie',
            data: {
                labels: genres,
                datasets: [{
                    data: genreCounts,
                    backgroundColor: colors.gradient,
                    borderColor: '#fff',
                    borderWidth: 3
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                plugins: {
                    legend: {
                        position: 'bottom'
                    }
                }
            }
        });
        
        // 기간 변경 함수
        function changePeriod(period, button) {
            // 모든 버튼의 active 클래스 제거
            document.querySelectorAll('.period-btn').forEach(btn => {
                btn.classList.remove('active');
            });
            
            // 클릭된 버튼에 active 클래스 추가
            button.classList.add('active');
            
            // 실제 구현에서는 여기서 Ajax를 통해 새로운 데이터를 가져와 차트를 업데이트
            console.log('기간 변경:', period);
        }
        
        // 실시간 업데이트 시뮬레이션
        setInterval(() => {
            // 실제 구현에서는 서버에서 최신 데이터를 가져와 차트를 업데이트
            console.log('데이터 업데이트 체크:', new Date().toLocaleTimeString());
        }, 30000); // 30초마다 체크
    </script>
</body>
</html>