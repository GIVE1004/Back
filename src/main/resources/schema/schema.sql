create table if not exists analysis
(
    id                             bigint auto_increment
        primary key,
    created_at                     datetime(6) not null,
    updated_at                     datetime(6) not null,
    audit                          text        null,
    finance                        text        null,
    news                           text        null,
    overall                        text        null,
    profile                        text        null,
    review                         text        null,
    public_interest_corporation_id bigint      not null
);

create table if not exists member
(
    id                bigint auto_increment
        primary key,
    email             varchar(255)                      null,
    nickname          varchar(255)                      null,
    oauth_server_id   varchar(255)                      not null,
    oauth_server      enum ('GOOGLE', 'KAKAO', 'NAVER') not null,
    profile_image_url varchar(255)                      null,
    role              enum ('ADMIN', 'MEMBER')          null,
    created_at        datetime(6)                       not null,
    updated_at        datetime(6)                       not null,
    constraint oauth_id_unique
        unique (oauth_server_id, oauth_server)
);

create table if not exists public_interest_corporations
(
    public_interest_corporation_id   int auto_increment
        primary key,
    public_interest_corporation_name varchar(64)  not null comment '공익법인명',
    representative_name              varchar(32)  not null comment '대표자',
    establishment_date               date         not null comment '설립연월일',
    road_name_address                varchar(64)  null comment '소재지',
    telephone_number                 varchar(16)  not null comment '전화번호',
    homepage_address                 varchar(256) null comment '홈페이지주소',
    email_address                    varchar(320) not null comment '전자우편주소',
    competent_authority              varchar(32)  null comment '주무관청',
    contribution_type                varchar(8)   not null comment '기부금유형',
    establishment_law                varchar(256) null comment '설립근거법',
    establishment_type               varchar(8)   not null comment '설립유형',
    public_business_type             varchar(8)   not null comment '공익사업유형',
    founding_entity                  varchar(8)   not null comment '설립주체',
    director_count                   int          not null comment '이사수',
    yearly_volunteer_count           int          not null comment '자원봉사자연인원수',
    employee_count                   int          not null comment '고용직원수',
    business_status                  varchar(512) null comment '정관에기재된공익목적사업현황',
    business_activities              varchar(256) null comment '사업내용',
    business_targets                 varchar(64)  null comment '사업대상',
    business_domestic_area           varchar(64)  null comment '국내주요사업지역',
    business_overseas_area           varchar(32)  null comment '국외주요사업지역',
    business_count                   int          null comment '총공익목적사업수',
    constraint public_interest_corporation_name
        unique (public_interest_corporation_name)
)
    comment '공익법인';

create table if not exists assets
(
    asset_id                       bigint auto_increment
        primary key,
    public_interest_corporation_id int    not null,
    base_year_month                int    not null,
    asset_total_sum                bigint not null comment '총계_총자산가액',
    asset_total_debt               bigint not null comment '총계_부채',
    asset_total_net_sum            bigint not null comment '총계_순자산_합계',
    asset_total_net_basic          bigint not null comment '총계_순자산_기본',
    asset_total_net_regular        bigint not null comment '총계_순자산_보통',
    asset_total_net_adjustment     bigint not null comment '총계_순자산_조정',
    asset_total_land               bigint not null comment '총계_토지',
    asset_total_building           bigint not null comment '총계_건물',
    asset_total_stock              bigint not null comment '총계_주식및출자지분',
    asset_total_finance            bigint not null comment '총계_금융자산',
    asset_total_etc                bigint not null comment '총계_기타자산',
    asset_public_sum               bigint not null comment '공익_총자산가액',
    asset_public_debt              bigint not null comment '공익_부채',
    asset_public_net_sum           bigint not null comment '공익_순자산_합계',
    asset_public_net_basic         bigint not null comment '공익_순자산_기본',
    asset_public_net_regular       bigint not null comment '공익_순자산_보통',
    asset_public_net_adjustment    bigint not null comment '공익_순자산_조정',
    asset_public_land              bigint not null comment '공익_토지',
    asset_public_building          bigint not null comment '공익_건물',
    asset_public_stock             bigint not null comment '공익_주식및출자지분',
    asset_public_finance           bigint not null comment '공익_금융자산',
    asset_public_etc               bigint not null comment '공익_기타자산',
    asset_etc_sum                  bigint not null comment '기타_총자산가액',
    asset_etc_debt                 bigint not null comment '기타_부채',
    asset_etc_net_sum              bigint not null comment '기타_순자산_합계',
    asset_etc_net_basic            bigint not null comment '기타_순자산_기본',
    asset_etc_net_regular          bigint not null comment '기타_순자산_보통',
    asset_etc_net_adjustment       bigint not null comment '기타_순자산_조정',
    asset_etc_land                 bigint not null comment '기타_토지',
    asset_etc_building             bigint not null comment '기타_건물',
    asset_etc_stock                bigint not null comment '기타_주식및출자지분',
    asset_etc_finance              bigint not null comment '기타_금융자산',
    asset_etc_etc                  bigint not null comment '기타_기타자산',
    constraint asset_corporation_year_uk
        unique (public_interest_corporation_id, base_year_month),
    constraint assets_ibfk_1
        foreign key (public_interest_corporation_id) references public_interest_corporations (public_interest_corporation_id)
)
    comment '자산현황';

create table if not exists expenses
(
    expense_id                                                 bigint auto_increment
        primary key,
    public_interest_corporation_id                             int    not null,
    base_year_month                                            int    not null,
    expense_public_total_sum                                   bigint not null comment '비용_공익_총계_합계',
    expense_public_total_business                              bigint not null comment '비용_공익_총계_사업',
    expense_public_total_general                               bigint not null comment '비용_공익_총계_일반',
    expense_public_total_fund_raising                          bigint not null comment '비용_공익_총계_모금',
    expense_public_business_sum                                bigint not null comment '비용_공익_사업_합계',
    expense_public_business_business                           bigint not null comment '비용_공익_사업_사업',
    expense_public_business_general                            bigint not null comment '비용_공익_사업_일반',
    expense_public_business_fund_raising                       bigint not null comment '비용_공익_사업_모금',
    expense_public_business_distribution_sum                   bigint not null comment '비용_공익_사업_분배비용_합계',
    expense_public_business_distribution_business              bigint not null comment '비용_공익_사업_분배비용_사업',
    expense_public_business_distribution_general               bigint not null comment '비용_공익_사업_분배비용_일반',
    expense_public_business_distribution_fund_raising          bigint not null comment '비용_공익_사업_분배비용_모금',
    expense_public_business_distribution_domestic_sum          bigint not null comment '비용_공익_사업_분배비용_국내_합계',
    expense_public_business_distribution_domestic_business     bigint not null comment '비용_공익_사업_분배비용_국내_사업',
    expense_public_business_distribution_domestic_general      bigint not null comment '비용_공익_사업_분배비용_국내_일반',
    expense_public_business_distribution_domestic_fund_raising bigint not null comment '비용_공익_사업_분배비용_국내_모금',
    expense_public_business_distribution_overseas_sum          bigint not null comment '비용_공익_사업_분배비용_국외_합계',
    expense_public_business_distribution_overseas_business     bigint not null comment '비용_공익_사업_분배비용_국외_사업',
    expense_public_business_distribution_overseas_general      bigint not null comment '비용_공익_사업_분배비용_국외_일반',
    expense_public_business_distribution_overseas_fund_raising bigint not null comment '비용_공익_사업_분배비용_국외_모금',
    expense_public_business_labor_sum                          bigint not null comment '비용_공익_사업_인력비용_합계',
    expense_public_business_labor_business                     bigint not null comment '비용_공익_사업_인력비용_사업',
    expense_public_business_labor_general                      bigint not null comment '비용_공익_사업_인력비용_일반',
    expense_public_business_labor_fund_raising                 bigint not null comment '비용_공익_사업_인력비용_모금',
    expense_public_business_facility_sum                       bigint not null comment '비용_공익_사업_시설비용_합계',
    expense_public_business_facility_business                  bigint not null comment '비용_공익_사업_시설비용_사업',
    expense_public_business_facility_general                   bigint not null comment '비용_공익_사업_시설비용_일반',
    expense_public_business_facility_fund_raising              bigint not null comment '비용_공익_사업_시설비용_모금',
    expense_public_business_etc_sum                            bigint not null comment '비용_공익_사업_기타비용_합계',
    expense_public_business_etc_business                       bigint not null comment '비용_공익_사업_기타비용_사업',
    expense_public_business_etc_general                        bigint not null comment '비용_공익_사업_기타비용_일반',
    expense_public_business_etc_fund_raising                   bigint not null comment '비용_공익_사업_기타비용_모금',
    expense_public_non_business_sum                            bigint not null comment '비용_공익_사업외_합계',
    expense_public_non_business_business                       bigint not null comment '비용_공익_사업외_사업',
    expense_public_non_business_general                        bigint not null comment '비용_공익_사업외_일반',
    expense_public_non_business_fund_raising                   bigint not null comment '비용_공익_사업외_모금',
    expense_public_reserve_funds_transfer_sum                  bigint not null comment '비용_공익_고유목적사업준비금전입액_합계',
    expense_public_reserve_funds_transfer_business             bigint not null comment '비용_공익_고유목적사업준비금전입액_사업',
    expense_public_reserve_funds_transfer_general              bigint not null comment '비용_공익_고유목적사업준비금전입액_일반',
    expense_public_reserve_funds_transfer_fund_raising         bigint not null comment '비용_공익_고유목적사업준비금전입액_모금',
    expense_etc_total_sum                                      bigint not null comment '비용_기타_합계',
    expense_etc_business_finance_sum                           bigint not null comment '비용_기타_사업_금융_합계',
    expense_etc_business_finance_etc                           bigint not null comment '비용_기타_사업_금융_기타',
    expense_etc_business_real_estate_sum                       bigint not null comment '비용_기타_사업_부동산_합계',
    expense_etc_business_real_estate_rental                    bigint not null comment '비용_기타_사업_부동산_임대',
    expense_etc_business_real_estate_sale                      bigint not null comment '비용_기타_사업_부동산_매각',
    expense_etc_business_etc                                   bigint not null comment '비용_기타_사업_기타',
    expense_etc_non_business                                   bigint not null comment '비용_기타_사업외',
    expense_etc_reserve_funds_transfer                         bigint not null comment '비용_기타_고유목적사업준비금환입',
    constraint expense_corporation_year_uk
        unique (public_interest_corporation_id, base_year_month),
    constraint expenses_ibfk_1
        foreign key (public_interest_corporation_id) references public_interest_corporations (public_interest_corporation_id)
)
    comment '비용현황';

create table if not exists gpt_analysis
(
    public_interest_corporation_id int  not null
        primary key,
    review_analysis                text null comment '리뷰 분석',
    news_analysis                  text null comment '언론 분석',
    overall_analysis               text not null comment '종합 분석',
    trust_score                    int  not null comment '신뢰 점수',
    audit_analysis                 text null comment '감사 분석',
    finance_analysis               text not null comment '재무 분석',
    profile_analysis               text not null comment '단체 분석',
    constraint gpt_analysis_ibfk_1
        foreign key (public_interest_corporation_id) references public_interest_corporations (public_interest_corporation_id)
);

create table if not exists profits
(
    profit_id                                   bigint auto_increment
        primary key,
    public_interest_corporation_id              int    not null,
    base_year_month                             int    not null,
    profit_public_total_sum                     bigint not null comment '수익_공익_합계',
    profit_public_business_sum                  bigint not null comment '수익_공익_사업_기부금품',
    profit_public_business_donation             bigint not null comment '수익_공익_사업_기부금품_개인기부',
    profit_public_business_donation_individual  bigint not null comment '수익_공익_사업_기부금품_영리법인',
    profit_public_business_donation_profit_corp bigint not null comment '수익_공익_사업_기부금품_공익법인',
    profit_public_business_donation_public_corp bigint not null comment '수익_공익_사업_기부금품_기타',
    profit_public_business_donation_etc         bigint not null comment '수익_공익_사업_기부금품_기부물품',
    profit_public_business_donation_item        bigint not null comment '수익_공익_사업_보조금',
    profit_public_business_subsidy              bigint not null comment '수익_공익_사업_회비수익',
    profit_public_business_membership_fee       bigint not null comment '수익_공익_사업_기타공익목적사업수익',
    profit_public_business_etc                  bigint not null comment '수익_공익_사업외',
    profit_public_non_business                  bigint not null comment '수익_공익_고유목적사업준비금환입액',
    profit_public_reserve_funds_reversal        bigint not null comment '수익_공익_사업_합계',
    profit_etc_total_sum                        bigint not null comment '수익_기타_합계',
    profit_etc_business_finance_sum             bigint not null comment '수익_기타_사업_금융_합계',
    profit_etc_business_finance_interest        bigint not null comment '수익_기타_사업_금융_이자',
    profit_etc_business_finance_dividend        bigint not null comment '수익_기타_사업_금융_배당',
    profit_etc_business_finance_etc             bigint not null comment '수익_기타_사업_금융_기타',
    profit_etc_business_real_estate_sum         bigint not null comment '수익_기타_사업_부동산_합계',
    profit_etc_business_real_estate_rental      bigint not null comment '수익_기타_사업_부동산_임대',
    profit_etc_business_real_estate_sale        bigint not null comment '수익_기타_사업_부동산_매각',
    profit_etc_business_etc                     bigint not null comment '수익_기타_사업_기타',
    profit_etc_non_business                     bigint not null comment '수익_기타_사업외',
    profit_etc_reserve_funds_reversal           bigint not null comment '수익_기타_고유목적사업준비금환입',
    constraint profit_corporation_year_uk
        unique (public_interest_corporation_id, base_year_month),
    constraint profits_ibfk_1
        foreign key (public_interest_corporation_id) references public_interest_corporations (public_interest_corporation_id)
)
    comment '수익현황';

create table if not exists survey
(
    id         bigint auto_increment
        primary key,
    created_at datetime(6) not null,
    updated_at datetime(6) not null,
    first      int         null,
    fourth     int         null,
    second     int         null,
    third      int         null,
    member_id  bigint      null,
    constraint UK_etac06cibj0amksgg9xb2c8q5
        unique (member_id),
    constraint FK8jxem4c3k9lo8nj4ebempero9
        foreign key (member_id) references member (id)
);

