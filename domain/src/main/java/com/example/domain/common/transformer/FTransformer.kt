package ir.hosseinabbasi.domain.common.transformer

import io.reactivex.FlowableTransformer

abstract class FTransformer<T> : FlowableTransformer<T, T>