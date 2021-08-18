package cdm.event.common;

import cdm.event.common.meta.TransfersMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaClass

public interface Transfers extends RosettaModelObject {
	Transfers build();
	Transfers.TransfersBuilder toBuilder();
	
	/**
	 */
	List<? extends Transfer> getTransfers();
	final static TransfersMeta metaData = new TransfersMeta();
	
	@Override
	default RosettaMetaData<? extends Transfers> metaData() {
		return metaData;
	} 
			
	static Transfers.TransfersBuilder builder() {
		return new Transfers.TransfersBuilderImpl();
	}
	
	default Class<? extends Transfers> getType() {
		return Transfers.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("transfers"), processor, Transfer.class, getTransfers());
	}
	
	
	interface TransfersBuilder extends Transfers, RosettaModelObjectBuilder {
		Transfer.TransferBuilder getOrCreateTransfers(int _index);
		List<? extends Transfer.TransferBuilder> getTransfers();
		Transfers.TransfersBuilder addTransfers(Transfer transfers);
		Transfers.TransfersBuilder addTransfers(Transfer transfers, int _idx);
		Transfers.TransfersBuilder addTransfers(List<? extends Transfer> transfers);
		Transfers.TransfersBuilder setTransfers(List<? extends Transfer> transfers);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("transfers"), processor, Transfer.TransferBuilder.class, getTransfers());
		}
		
	}
	
	//Transfers.TransfersImpl
	class TransfersImpl implements Transfers {
		private final List<? extends Transfer> transfers;
		
		protected TransfersImpl(Transfers.TransfersBuilder builder) {
			this.transfers = ofNullable(builder.getTransfers()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends Transfer> getTransfers() {
			return transfers;
		}
		
		@Override
		public Transfers build() {
			return this;
		}
		
		@Override
		public Transfers.TransfersBuilder toBuilder() {
			Transfers.TransfersBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Transfers.TransfersBuilder builder) {
			ofNullable(getTransfers()).ifPresent(builder::setTransfers);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Transfers _that = getType().cast(o);
		
			if (!ListEquals.listEquals(transfers, _that.getTransfers())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (transfers != null ? transfers.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Transfers {" +
				"transfers=" + this.transfers +
			'}';
		}
	}
	
	//Transfers.TransfersBuilderImpl
	class TransfersBuilderImpl implements Transfers.TransfersBuilder {
	
		protected List<Transfer.TransferBuilder> transfers = new ArrayList<>();
	
		public TransfersBuilderImpl() {
		}
	
		@Override
		public List<? extends Transfer.TransferBuilder> getTransfers() {
			return transfers;
		}
		
		public Transfer.TransferBuilder getOrCreateTransfers(int _index) {
		
			if (transfers==null) {
				this.transfers = new ArrayList<>();
			}
			Transfer.TransferBuilder result;
			return getIndex(transfers, _index, () -> {
						Transfer.TransferBuilder newTransfers = Transfer.builder();
						return newTransfers;
					});
		}
		
	
		@Override
		public Transfers.TransfersBuilder addTransfers(Transfer transfers) {
			if (transfers!=null) this.transfers.add(transfers.toBuilder());
			return this;
		}
		
		@Override
		public Transfers.TransfersBuilder addTransfers(Transfer transfers, int _idx) {
			getIndex(this.transfers, _idx, () -> transfers.toBuilder());
			return this;
		}
		@Override 
		public Transfers.TransfersBuilder addTransfers(List<? extends Transfer> transferss) {
			if (transferss != null) {
				for (Transfer toAdd : transferss) {
					this.transfers.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Transfers.TransfersBuilder setTransfers(List<? extends Transfer> transferss) {
			if (transferss == null)  {
				this.transfers = new ArrayList<>();
			}
			else {
				this.transfers = transferss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public Transfers build() {
			return new Transfers.TransfersImpl(this);
		}
		
		@Override
		public Transfers.TransfersBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Transfers.TransfersBuilder prune() {
			transfers = transfers.stream().filter(b->b!=null).<Transfer.TransferBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTransfers()!=null && getTransfers().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Transfers.TransfersBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Transfers.TransfersBuilder o = (Transfers.TransfersBuilder) other;
			
			merger.mergeRosetta(getTransfers(), o.getTransfers(), this::getOrCreateTransfers);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Transfers _that = getType().cast(o);
		
			if (!ListEquals.listEquals(transfers, _that.getTransfers())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (transfers != null ? transfers.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransfersBuilder {" +
				"transfers=" + this.transfers +
			'}';
		}
	}
}
